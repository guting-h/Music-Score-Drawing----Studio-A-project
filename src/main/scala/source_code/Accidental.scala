package source_code

sealed trait Accidental {
  def sign: Char
}

class Sharp   extends Accidental {
  def sign: Char = '♯'
}

class Flat    extends Accidental {
  def sign: Char = '♭'
}

class Natural extends Accidental {
  def sign: Char = '♮'
}

/** companinon object of trait Accidental
 *  used to create accidentals conveniently */
object Accidental {
  def apply(a: String): Option[Accidental] = {
    a match {
      case "^" => Option(new Sharp)
      case "_" => Option(new Flat)
      case "=" => Option(new Natural)
      case _   => None
    }
  }
}