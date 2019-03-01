package com.yiyou.appsvr.recorder

import org.apache.zookeeper.{ZooKeeper, Watcher, WatchedEvent}
import org.apache.zookeeper.Watcher.Event.KeeperState
import org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE
import org.apache.zookeeper.CreateMode

import Recordercomm.RecorderWorkerData



class Worker(val zkConnectString: String, val workerId: String, val localHostPort: String, val capacity: Int=100) extends Watcher {
  private var connected_ = false
  private var expired_ = false
  private var zk: ZooKeeper = null

  def startZK() = {
    println("startZK");
    val sessionTimeout = 15000
    zk = new ZooKeeper(zkConnectString, sessionTimeout, this)
  }

  def isConnected() = connected_ 
  def isExpired() = expired_

  def register() = {
    println("register");
    val builder = RecorderWorkerData.newBuilder()
    val hostport = localHostPort.split(':')
    builder.setId(workerId)
    builder.setHost(hostport(0))
    builder.setPort(hostport(1).toInt)
    builder.setCapacity(capacity);

    val workerData = builder.build()
    val buf = workerData.toByteArray()

    println(workerData.toString())

    var path = "/recorder/workers" + "/" + workerId
    path = zk.create(path, buf, OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL) 
    println("created path:" + path)
  }
  

  //process(WatchedEvent event)
  def process(event: WatchedEvent): Unit = {
    if (event.getType == Watcher.Event.EventType.None) {
      event.getState match {
        case KeeperState.SyncConnected =>  {
          println("connected")
          connected_ = true
        }
        case KeeperState.Disconnected =>  {
          println("Disconnected")
          connected_ = false
        }
        case KeeperState.Expired => {
          println("Expired")
          connected_ = false
          expired_ = true
        }
        case _ => 
      }
    }
  }
}

object Worker {

  //commands option table
  type OptionTable = Map[Symbol, Any]  

  def nextOption(tbl: OptionTable, arglist: List[String]) : OptionTable = {
    arglist match {
      case Nil => tbl
      case "--zookeeper" :: value :: tail => nextOption(tbl + ('zookeeper -> value), tail)
      case "--worker" :: value :: tail => nextOption(tbl + ('worker -> value), tail)
      case "--localaddr" :: value :: tail => nextOption(tbl + ('localaddr -> value), tail)
      case "--capacity" :: value :: tail => nextOption(tbl + ('capacity -> value.toInt), tail)
      case option :: tail  => println("Unknown option " + option) 
                              nextOption(tbl, tail)
    }
  }

  def main(args: Array[String]) : Unit = {
    val usage = "--zookeeper <zookeeper, ip:port>  --worker <workerId>  --localaddr <localaddr, ip:port> --capacity <capacity, default 100>"
    if(args.length == 0) { 
      println(usage)
      return
    }

    val optionTbl = nextOption(Map(), args.toList)

    val zkConnectString = optionTbl.getOrElse('zookeeper, "").asInstanceOf[String]
    val workerId = optionTbl.getOrElse('worker, "").asInstanceOf[String]
    val localHostPort = optionTbl.getOrElse('localaddr, "").asInstanceOf[String]
    val capacity = optionTbl.getOrElse('capacity, 100).asInstanceOf[Int]

    if( (zkConnectString.length == 0) || (workerId.length == 0) || (localHostPort.length == 0)) {
      println(usage)
      return
    }

    val worker = new Worker(zkConnectString, workerId, localHostPort, capacity)

    worker.startZK()

    while(!worker.isConnected && !worker.isExpired){
      Thread.sleep(1000)
    }

    worker.register();

    //Thread.sleep(10000)
    while(true) {
      Thread.sleep(1000)
    }
    
  }
}

