object ForMain {
    def main(args: Array[String]) {
        val filesHere = (new java.io.File("src/main/scala/book/")).listFiles

        def fileLines(file: java.io.File) = 
            scala.io.Source.fromFile(file).getLines().toList

        def grep(pattern: String) =
            for {
            file <- filesHere
            if file.getName.endsWith(".scala")
                line <- fileLines(file)
            trimmed = line.trim
            if trimmed.matches(pattern)
            } println(file + ": " + trimmed)

        grep(".*Main.*")

        println
        val forLinesLength =
            for {
                file <- filesHere
                if file.getName.endsWith(".scala")
                line <- fileLines(file)
                trimmed = line.trim
                if trimmed.matches(".*for.*")
            } yield trimmed.length
        for(i <- forLinesLength) println(i)
    }
}

// vim: set ts=4 sw=4 et:
