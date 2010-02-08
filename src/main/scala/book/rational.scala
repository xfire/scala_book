
class Rational(n: Int, d: Int) {
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g

    def this(n: Int) = this(n, 1)

    def + (that: Rational): Rational =
        new Rational(numer * that.denom +
                     denom * that.numer,
                     denom * that.denom)

    def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}

object RationalMain {
    def main(args: Array[String]) {
        println(new Rational(1, 2))

        try {
            println(new Rational(24, 0))
        } catch {
            case e:IllegalArgumentException => println("Rational(23, 0) handled correctly")
        }

        println(new Rational(66, 42))
    }
}

// vim: set ts=4 sw=4 et:
