import scala.io.Source

object CurryingMain {
  def main(args: Array[String]) {

    def withFile(name: String)(func: Iterator[String] => Iterator[String]) = {
      val src = Source.fromPath(name)
      try {
        func(src.getLines()).toList
      } 
      finally {
        src.close
      }
    }

    def grep(name: String, pattern: String) =
      withFile(name) {
        l => for(line <- l if line.matches(pattern)) yield line
      }

    println("-" * 60)
    grep("src/main/scala/book/currying.scala", ".*def.*").foreach(println)
    println("-" * 60)
  }
}

// vim: set ts=2 sw=2 et:
