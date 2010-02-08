object ListReverseMain {
  def main(args: Array[String]) {
    def reverse[T](xs: List[T]): List[T] = xs match {
      case Nil => xs
      case x :: xs => reverse(xs) ::: x :: Nil
    }

    def reverse2[T](xs: List[T]): List[T] = xs.foldLeft(List[T]())((l, r) => r :: l)

    val l = (1 to 10).toList

    assert(reverse(l) == l.reverse)
    assert(reverse2(l) == l.reverse)
    
    println("-" * 60)
    println(reverse(l))
    println(reverse2(l))
    println("-" * 60)
  }
}

// vim: set ts=2 sw=2 et:
