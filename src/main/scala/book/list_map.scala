object ListMapMain {
  def main(args: Array[String]) {
    def transform(xs: List[Any]): List[Any] = for{
      e <- xs
      v = e match {
        case i: Int => "Int(%d)" format i
        case s: String => "String(%s)" format s
        case l: List[Any] => transform(l)
        case x => "Unknown(%s)" format x
      }
    } yield v

    def lprint(xs: List[Any], ident: Int = 0): Unit = for{
      e <- xs
      v = e match {
        case l: List[Any] => lprint(l, ident + 1)
        case e => println(" " * ident + e)
      }
    } yield v

    val l = List(23.42, 1,List(23, List("b", 42), "a"),3, "z")

    println("-" * 60)
    lprint(l)
    println("-" * 60)
    lprint(transform(l))
    println("-" * 60)
  }
}

// vim: set ts=2 sw=2 et:
