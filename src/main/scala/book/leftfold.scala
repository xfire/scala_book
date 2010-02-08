object LeftFoldMain {
    def main(args: Array[String]) {
        val l = List(42,23,1,99,15)
        val e: Int = l.foldLeft(0)((a, b) => if(a > b) a else b)
        assert(e == l.max)
    }
}
