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
    val sessionTimeout = 15000
    zk = new ZooKeeper(zkConnectString, sessionTimeout, this)
  }

  def isConnected() = connected_ 
  def isExpired() = expired_

  def register() = {
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
  def main(args: Array[String]) : Unit = {
    val usage = "<zookeeper> <workerId>  <localhostport> [capacity]"

    println("command line argument:" + args.mkString(" "))

    val zkConnectString = if (args.length >= 1) args(0) else "192.168.9.227:2181"
    val workerId = if (args.length >= 2) args(1) else "r00001"
    val localHostPort = if (args.length >= 3) args(2) else "127.0.0.1:15657"
    val capacity = if (args.length >=4) args(3).toInt else 100

    val worker = new Worker(zkConnectString, workerId, localHostPort, capacity)

    worker.startZK()

    while(!worker.isConnected && !worker.isExpired){
      Thread.sleep(1000)
    }

    worker.register();

    while(true) {
      Thread.sleep(1000)
    }
    
  }
}

