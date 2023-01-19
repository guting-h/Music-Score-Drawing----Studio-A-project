package source_code

/** companion object of trait Key */
object Key {
  def isDefined(someK: String): Boolean = {
    val range = Array("C", "G", "D", "A", "E", "F", "Bb", "Eb")
    range.contains(someK)
  }

  def apply(k: String) = {
    k match {
      case "C" => new CMajor
      case "G" => new GMajor
      case "D" => new DMajor
      case "A" => new AMajor
      case "E" => new EMajor
      case "F" => new FMajor
      case "Bb" => new BFlatMajor
      case "Eb" => new EFlatMajor
      case _    => throw new UnknownKeyException("Key type not supported")
    }
  }
}

trait Key {
  def getKey: Array[String]
}

class CMajor extends Key {
  def getKey = {
      Array("",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "",
          "" ).reverse
  }
}

class GMajor extends Key {
  def getKey = {
    Array("     ",
          "     ",
          "     ",
          "     ",
          "--♯--",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}

class DMajor extends Key {
  def getKey = {
    Array("     ",
          "     ",
          "     ",
          "     ",
          "--♯--",
          "     ",
          "-----",
          "   ♯ ",
          "-----",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}

class AMajor extends Key {
  def getKey = {
    Array("     ",
          "     ",
          "     ",
          "   ♯ ",
          "-♯---",
          "     ",
          "-----",
          "  ♯  ",
          "-----",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}

class EMajor extends Key {
  def getKey = {
    Array("     ",
          "     ",
          "     ",
          "  ♯  ",
          "♯----",
          "     ",
          "---♯-",
          " ♯   ",
          "-----",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}

class FMajor extends Key {
  def getKey = {
      Array("     ",
          "     ",
          "     ",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "--♭--",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}

class BFlatMajor extends Key {
  def getKey = {
    Array("     ",
          "     ",
          "     ",
          "     ",
          "-----",
          "   ♭ ",
          "-----",
          "     ",
          "-♭---",
          "     ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}

class EFlatMajor extends Key {
  def getKey = {
    Array("     ",
          "     ",
          "     ",
          "     ",
          "-----",
          "  ♭  ",
          "-----",
          "     ",
          "♭----",
          "  ♭  ",
          "-----",
          "     ",
          "-----",
          "     ",
          "     ",
          "     " ).reverse
  }
}