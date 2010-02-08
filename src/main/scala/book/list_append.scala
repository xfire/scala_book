object ListAppendMain {
  def main(args: Array[String]) {
    def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
      case Nil => ys
      case x :: xs => x :: append(xs, ys)
    }

    val a = List(1,2,3)
    val b = List(4,5,6)

    assert(append(Nil, a) == a)
    assert(append(b, Nil) == b)
    assert(append(a, b) == a ::: b)
    assert(append(b, a) == b ::: a)
    
    println("-" * 60)
    println(append(a, b))
    println(append(b, a))
    println("-" * 60)
  }
}

// vim: set ts=2 sw=2 et:
