ThisBuild / name := "ZKBookExam"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.12.7"

/*target := file("/home/zp/tmp/zk")*/

enablePlugins(JavaAppPackaging)

/*libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.4.13" pomOnly()*/
libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.4.13"
