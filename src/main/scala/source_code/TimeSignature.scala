package source_code


trait TimeSignature {

  def graphic: Array[String]

}

/** currently only 4/4 time is supported */
class CommonTime extends Clef {

  def graphic: Array[String] = {
    Array("       ",
          "       ",
          "       ",
          "       ",
          "-------",
          "       ",
          "-------",
          " ╭╭--╮ ",
          "-||----",
          " ||    ",
          "--╰--╯-",
          "       ",
          "-------",
          "       ",
          "       ",
          "       " ).reverse
  }

}
