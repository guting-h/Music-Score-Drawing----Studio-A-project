import org.scalatest.flatspec.AnyFlatSpec
import source_code._

/** a clumsy version of twinkle twinkle little star */
class PieceTest extends AnyFlatSpec {
  val no = "  "
  println("Twinkle Little Star")
  val star = new Piece("Twinkle Little Star", "Mozart", "C")
  star.addLine("C4 C4 G4 G4 | A4 A4 G8 | F4 F4 E4 E4 | D4 D4 C8 |",no)
  star.addLine("G4 G4 F4 F4 | E4 E4 D8 | G4 G4 F4 F4 | E4 E4 D8 |", "Up a -bove the world so high, Like a dia -mond in the sky")
  star.addLine("C4 C4 G4 G4 | A4 A4 G8 | F4 F4 E4 E4 | D4 D4 C8 |", no)
  star.finish()
  star.drawScore()

  /** prints all the rests and various combination of notes */
  println("rests, scales, beams, and chords: ")
  val rest = new Piece("PieceTest", "no one", "Eb")
  rest.addLine("z4 | z1 z2 z4 z8 | z16 | |", no)
  rest.addLine("C4 D4 E4  F4 | G4 A4  B4 c4 | d4 e4 f4 e4 | d4 c4 B4 A4 | G4 F4 E4 D4 | C8 |    c'4 b4 a4 g4 |",no)
  rest.addLine("C2,^D2,E2,=F2 | _G2,A2  [B2,_c2] | d2 ^e2 f3 e2 | [d1,=c1] B1 A1 | G4 F8 E4 D16 | C8 |    c'2,b2,a2 g4 |",no)
  rest.finish()
  rest.drawScore()
  rest.goodBye()
}
