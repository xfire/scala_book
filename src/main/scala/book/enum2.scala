// version to get it running under sbt...

object Planet extends Enumeration {
  
  // seems to need that trait. without it, the execution hangs in the foreach
  // in the main. don't know exactly why. maybe someone has a hint...
  trait PlanetData {
    val surfaceGravity: Double
    def surfaceWeight(otherMass: Double): Double
  }

  case class PlanetVal(mass: Double, radius: Double) extends Val with PlanetData {
    // universal gravitational constant  (m3 kg-1 s-2)
    val G = 6.67300E-11
    val surfaceGravity = G * mass / (radius * radius)
    def surfaceWeight(otherMass: Double) = otherMass * surfaceGravity
  }

  val MERCURY = PlanetVal(3.303e+23, 2.4397e6)   
  val VENUS   = PlanetVal(4.869e+24, 6.0518e6)
  val EARTH   = PlanetVal(5.976e+24, 6.37814e6)
  val MARS    = PlanetVal(6.421e+23, 3.3972e6)
  val JUPITER = PlanetVal(1.9e+27,   7.1492e7)
  val SATURN  = PlanetVal(5.688e+26, 6.0268e7)
  val URANUS  = PlanetVal(8.686e+25, 2.5559e7)
  val NEPTUNE = PlanetVal(1.024e+26, 2.4746e7)

  // needed I think because Enumeration.elements is final and return the invariant 
  // type Enumeration.Value :|
  implicit def valueToPlanet(v: Value): PlanetData = v.asInstanceOf[PlanetData]
}

object EnumMain {
  def main(args: Array[String]) {

    if (args.length < 1) {
      println("Usage:  scala Planet <earth_weight>")
    } else {
      import Planet._
      val earthWeight = args(0) toInt
      val mass = earthWeight / EARTH.surfaceGravity

      Planet.values.foreach( p =>
        println("Your weight on %s is %f".format(p, p.surfaceWeight(mass)))
      )
    }

  }
}

// vim: set ts=2 sw=2 et:
