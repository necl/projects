import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {
    
    val testInt: Int = 2
    def processLine(line: String) = {
      if(line.length > width) {
        println(filename + testInt + ": " + line.trim)
      }
    }
    val source = Source.fromFile(filename)
    for(line <- source.getLines()) {
      processLine(line)
    }
  }
  
  //private def processLine(filename: String, width: Int, line: String) = {
  //  if(line.length > width) {
  //    println(filename + ": " + line.trim)
  //  }
  //}
}

object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for(arg <- args.drop(1)) {
      LongLines.processFile(arg, width)
    }
  }
}
