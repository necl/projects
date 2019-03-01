ThisBuild / name := "zkclient"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.12.7"

enablePlugins(JavaAppPackaging)

libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.4.13"

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.11.2"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.11.2"

