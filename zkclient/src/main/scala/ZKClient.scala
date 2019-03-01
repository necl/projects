
package com.yiyou.appsvr.zkclient

import org.apache.zookeeper.{ZooKeeper, Watcher, WatchedEvent}
import org.apache.zookeeper.Watcher.Event.KeeperState
import org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE
import org.apache.zookeeper.CreateMode

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ZKClient {
}

object ZKClient {
  def main(args: Array[String]): Unit {
    val usage = "ZKClient <command> [options] [arguments]"

  }
}
