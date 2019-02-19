
import org.apache.zookeeper.{ZooKeeper, Watcher, WatchedEvent}
import org.apache.zookeeper.Watcher.Event.KeeperState
import org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE
import org.apache.zookeeper.CreateMode
import recorder.Recordercomm



class Worker( val hostPort: String) extends Watcher {
  private val workerid = "r00001"
  private var connected_ = false
  private var expired_ = false
  private var zk: ZooKeeper = null

  def startZK() = {
    val sessionTimeout = 15000
    zk = new ZooKeeper(hostPort, sessionTimeout, this)
  }

  def isConnected() = connected_ 
  def isExpired() = expired_

  def register() = {
    val builder = Recordercomm.RecorderWorkerData.newBuilder()
    builder.setId(workerid);
    builder.setHost("127.0.0.1")
    builder.setPort(15657)
    builder.setCapacity(100);

    val workerData = builder.build()
    val buf = workerData.toByteArray()

    //println(workerData.toString())

    var path = "/recorder/workers" + "/" + workerid
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

    val worker = new Worker("192.168.9.227:2181")

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
