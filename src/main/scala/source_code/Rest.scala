package source_code

trait Rest extends Note {
}

class WholeRest extends Rest {
  var accidental = Option[Accidental](new Natural)
  var dotted = false
  var sIndex = 8
  val symbol = '▀'

  private val lines = staff.clone()
  def config: Array[String] = {
    lines(8) = s"   ${symbol}   "
    lines
  }
}

class HalfRest extends Rest {
  var accidental = Option[Accidental](new Natural)
  var dotted = false
  var sIndex = 7
  val symbol = '▅'

  private val lines = staff.clone()
  def config: Array[String] = {
    lines(7) = s"---${symbol}---"
    lines
  }
}

class QuarterRest extends Rest {
  var accidental = Option[Accidental](new Natural)
  var dotted = false
  var sIndex = 9
  lazy val symbol = '⎞'

  private val lines = staff.clone()
  def config: Array[String] = {
    lines(6) = "   /   "
    lines(7) = "---⎞---"
    lines(8) = "   /   "
    lines(9) = "---⎞---"
    lines
  }
}

class EighthRest extends Rest {
  var accidental = Option[Accidental](new Natural)
  var dotted = false
  var sIndex = 7
  lazy val symbol = '●'

  private val lines = staff.clone()
  def config: Array[String] = {
    lines(7) = "---●/--"
    lines(6) = "   /   "
    lines
  }
}

class SixteenthRest extends Rest {
  var accidental = Option[Accidental](new Natural)
  var dotted = false
  var sIndex = 7
  lazy val symbol = '●'

  private val lines = staff.clone()
  def config: Array[String] = {
    lines(7) = "---●/--"
    lines(6) = "  ●/   "
    lines(5) = "--/----"
    lines
  }
}