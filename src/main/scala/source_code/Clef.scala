package source_code

trait Clef {
  def graphic: Array[String]
}

/** currently only treble clef is supported;
 *  other types of clef can be extended later */
class TrebleClef extends Clef {

  def graphic: Array[String] = {
    val config = Array("            ",
                       "            ",
                       "            ",
                       "            ",
                       "------_-----",
                       "    // ⎞    ",
                       "-----⎝_/----",
                       "      //    ",
                       "---_//—__---",
                       "  // __ ⎞  ",
                       "--(( @⎺ ))-",
                       "   ⎝____/  ",
                       "-----------",
                       "     @/     ",
                       "            ",
                       "            ")
    config.reverse
  }
}
