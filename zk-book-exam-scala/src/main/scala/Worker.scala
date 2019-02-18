package org.apache.zookeeper.book

import org.apache.zookeeper.{ZooKeeper, Watcher, WatchedEvent}


object Worker extends Watcher {
  def main(args: Array[String]) = {
    println("Worker")
  }

  def process(event: WatchedEvent) = {
  }
  
}

