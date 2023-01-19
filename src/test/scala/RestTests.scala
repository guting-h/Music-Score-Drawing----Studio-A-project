import org.scalatest.flatspec.AnyFlatSpec
import source_code._

/** tests all the rests */
class WholeRestTest extends AnyFlatSpec {
  val wr = new WholeRest
  val hr = new HalfRest
  val qr = new QuarterRest
  val er = new EighthRest
  val sr = new SixteenthRest
  wr.config.reverse.map(println(_))
  hr.config.reverse.map(println(_))
  qr.config.reverse.map(println(_))
  er.config.reverse.map(println(_))
  sr.config.reverse.map(println(_))
}