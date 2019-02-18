package org.apache.zookeeper.book

import org.apache.zookeeper.{ZooKeeper, Watcher, WatchedEvent}


object Master extends Watcher {
  def main(args: Array[String]) = {
    println("Master")
    val zk = new ZooKeeper("localhost:2181", 10000, this)

    Thread.sleep(30*1000)

  }

  def process(event: WatchedEvent) = {
  }
  
}

