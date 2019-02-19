ThisBuild / name := "recorderworker"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.12.7"

enablePlugins(JavaAppPackaging)

libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.4.13"

libraryDependencies += "com.google.protobuf" % "protobuf-java" % "3.2.0"
