object StripMarginMain {
    def main(args: Array[String]) {
        println("-" * 60)
        println("""this is
                   a bad example...""")
        println("-" * 60)
        println("""|this is
                   |a good example...""".stripMargin)
        println("-" * 60)
    }
}
