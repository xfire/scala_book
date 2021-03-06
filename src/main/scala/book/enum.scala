object Planet extends Enumeration {
  
  case class PlanetVal(name: String, mass: Double, radius: Double) extends Val(name) {
    // universal gravitational constant  (m3 kg-1 s-2)
    val G = 6.67300E-11
    val surfaceGravity = G * mass / (radius * radius)
    def surfaceWeight(otherMass: Double) = otherMass * surfaceGravity
  }

  val MERCURY = PlanetVal("Mercury", 3.303e+23, 2.4397e6)
  val VENUS   = PlanetVal("Venus",   4.869e+24, 6.0518e6)
  val EARTH   = PlanetVal("Earth",   5.976e+24, 6.37814e6)
  val MARS    = PlanetVal("Mars",    6.421e+23, 3.3972e6)
  val JUPITER = PlanetVal("Jupiter", 1.9e+27,   7.1492e7)
  val SATURN  = PlanetVal("Saturn",  5.688e+26, 6.0268e7)
  val URANUS  = PlanetVal("Uranus",  8.686e+25, 2.5559e7)
  val NEPTUNE = PlanetVal("Neptune", 1.024e+26, 2.4746e7)

  // needed I think because Enumeration.elements is final and return the invariant 
  // type Enumeration.Value :|
  implicit def valueToPlanet(v: Value): PlanetVal = v.asInstanceOf[PlanetVal]
}

object EnumMain {
  def main(args: Array[String]) {

    if (args.length < 1) {
      println("Usage:  scala Planet <earth_weight>")
    } else {
      import Planet._
      val earthWeight = args(0) toInt
      val mass = earthWeight / EARTH.surfaceGravity

      Planet.foreach( p =>
        println("Your weight on %s is %f".format(p, p.surfaceWeight(mass)))
      )
    }

  }
}

// vim: set ts=2 sw=2 et:
