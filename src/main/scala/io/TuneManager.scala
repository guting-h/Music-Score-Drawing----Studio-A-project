package io
import source_code._

import java.io.{BufferedWriter, FileNotFoundException, FileWriter, IOException}
import scala.io.Source

class TuneManager {

  /** saves the tune from the ui to a new file named with the title of the piece */
  def saveTune(filePath: String, piece: Piece): Unit = {
    val content = piece.lines
    val fileWriter = new FileWriter(filePath)
    val buffWriter = new BufferedWriter(fileWriter)
    try {
      buffWriter.write(content.mkString("\n"))
    } catch {
      case _: FileNotFoundException => println("Error with saving tune data: Save file not found")
      case _: IOException => println("Error with saving tune data: IOException")
    } finally {
      buffWriter.close()
    }
  }

  def readTune(filePath: String): Unit = {

    try {
      val file = Source.fromFile(filePath)
      val lines = file.getLines()
      var currentLine = ""

      var title = "No Title"
      var composer = "anonymous"
      var key = "C"
      var piece = new Piece(title, composer, key) // a dummy that will be replaced
      var pieceReplaced = false

      while (lines.hasNext) {
        currentLine = lines.next()
        if (currentLine.nonEmpty && !currentLine.isBlank) {
          if (currentLine.contains(":")) {
            readInfo(currentLine)
          } else {
            generatePiece()
            var lyric = lines.next().split(":")
            if (lyric.head.contains("w")) {
              if (lyric.length == 1) {
                lyric = lyric ++ Array(" ")
              }
              piece.addLine(currentLine.trim(), lyric(1))
            } else {
              file.close()
              throw new CorruptedFileException("Lyric section missing")
            }
          }
        }
      }

      def readInfo(s: String) = {
        var clean = currentLine.split(":").map(_.trim())
        clean(0) match {
          case "T" => title = clean(1)
          case "C" => composer = clean(1)
          case "K" => key = clean(1)
          case  _  => // ignores all other types of headings
        }
      }

      def generatePiece() = {
        if (!pieceReplaced && Key.isDefined(key)) {
          piece = new Piece(title, composer, key)
          pieceReplaced = true
        }
      }
      piece.finish()
      file.close()
      println("\n✨ COMPLETE ✨" +
              "\n Errors with file format shown above, if any")
    } catch {
      case f: FileNotFoundException => println("❌FAIL: File not found")
      case e: CorruptedFileException => println("❌FAIL: "+e.getMessage)
      case e: IOException => println("❌FAIL: Failed to read file")
      case e: NoSuchElementException => println("❌FAIL: Is something missing? Check the lyric section. ")
    }

  }
}