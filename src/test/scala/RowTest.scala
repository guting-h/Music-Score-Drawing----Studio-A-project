import org.scalatest.flatspec.AnyFlatSpec
import source_code._

/** tests the printout of rows of a piece */
class RowTest extends AnyFlatSpec {
  println("The Flower of the Forest")
  println("                          anon.(Scotland)")
  val key = new GMajor
  val r1 = new Row(key)
  r1.setFirst()
  r1.addNote("G4")
  r1.addNotes("G2,G2")
  r1.addNote("A2")
  r1.addNotes("B2,d2,e2")
  r1.addBreak()
  r1.addNotes("d2,B2")
  r1.addNotes("A2,G2")
  r1.addNote("E4")
  r1.addNotes("D2,G2")
  r1.addBreak()
  r1.constructLine()
  r1.getRow.reverse.map(println(_))

  val r2 = new Row(key)
  r2.addNote("G4")
  r2.addNotes("G2,G2")
  r2.addNote("A2")
  r2.addNotes("B2,d2,e2")
  r2.addBreak()
  r2.addNotes("d2,B2")
  r2.addNote("A3")
  r2.addNote("G1")
  r2.addNote("G6")
  r2.addNote("D2")
  r2.addBreak()
  r2.end()
  r2.getRow.reverse.map(println(_))

  val r3 = new Row(key)
  r3.addChord("[D1,E1,G1,c1, g1]")
  r3.addChord("[D16,F16,A16, G16]")
  r3.constructLine()
  r3.getRow.reverse.map(println(_))

  /** tests whether method createNote returns the correct instance of Note
   *  when fed with various inputs.
   *  Need to set createNote to public in order to run */
  /*"createNote" should "create the correct type of note" in {
    intercept[IllegalArgumentException] {
      r1.createNote("C")
    }
    assert(r1.createNote("C1").isInstanceOf[SixteenthNote])
    assert(r1.createNote("D2").isInstanceOf[EighthNote])
    assert(r1.createNote("^E3").isInstanceOf[EighthNote])
    assert(r1.createNote("=F4").isInstanceOf[QuarterNote])
    assert(r1.createNote("_G6").isInstanceOf[QuarterNote])
    assert(r1.createNote("g8").isInstanceOf[HalfNote])
    assert(r1.createNote("b12").isInstanceOf[HalfNote])
    assert(r1.createNote("=b16").isInstanceOf[WholeNote])
  }*/

}
