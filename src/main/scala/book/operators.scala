/*
 * left- and right-associative operators
 *
 * behave not the same!
 */

class OP(val v: Int) {
    def :- (o: OP) = v + " :- " + o.v
    def -: (o: OP) = v + " -: " + o.v

    def unary_~ = v * v
}

object OperatorsMain {
    def main(args: Array[String]) {
        val a = new OP(23)
        val b = new OP(42)
        val c = new OP(3)

        println("-" * 60)
        println("normal behaviour")
        println("a :- b  -> " + (a :- b))
        println("a.:-(b) -> " + a.:-(b))

        println("-" * 60)

        println("colon on the right side will change the parameters")
        println("a -: b  ->" + (a -: b))
        println("a.-:(b) ->" + a.-:(b))
        println("b.-:(a) ->" + b.-:(a))

        println("-" * 60)

        println("prefix operator")
        println("~3        -> " + (~c))
        println("3.unary_~ -> " + (c.unary_~))

        println("-" * 60)
    }
}
