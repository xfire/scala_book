object Quicksort {
    
    def qsort[T <% Ordered[T]](xs: List[T]): List[T] = xs match {
        case Nil => Nil
        case x :: xs =>
            val (a, b) = xs partition(_ < x)
            qsort(a) ++ (x :: qsort(b))
    }
    
    def qsort2[T <% Ordered[T]](xs: List[T]): List[T] = xs match {
        case Nil => Nil
        case x :: xs =>
            val (a, b) = xs partition(_ < x)
            qsort(a) ::: x :: qsort(b)
    }
    
    def main(args: Array[String]) = {
        val l = List(23,13,42,43,99)

        assert(qsort(l) == l.sortWith(_ < _))
        assert(qsort2(l) == l.sortWith(_ < _))

        println("-" * 60)
        println(qsort(l))
        println(qsort2(l))
        println("-" * 60)
    }
}
