package org.apache.zookeeper.book

import org.apache.zookeeper.{ZooKeeper, Watcher, WatchedEvent}

class Master extends Watcher {

  def process(event: WatchedEvent) = {
  }
  
}

object Master {
  def main(args: Array[String]) = {
    val zk = new ZooKeeper("localhost:2181", 10000, this)

    Thread.sleep(30*1000)

  }

}

