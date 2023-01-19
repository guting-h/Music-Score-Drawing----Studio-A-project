package ui
import io._
import source_code._

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

object MusicScoreTextUI extends App {
  private val manager = new TuneManager
  private var finished = false
  private var piece = new Piece("No title", "anonymous", "C") // a dummy that will be replaced

  this.welcome()

  /** directs the program to tune reading or tune writing */
  private def welcome(): Unit = {
    println("\n              ✧˖° 𝐖𝐞𝐥𝐜𝐨𝐦𝐞 𝐭𝐨 𝐌𝐮𝐬𝐢𝐜 𝐒𝐜𝐨𝐫𝐞 𝐃𝐫𝐚𝐰𝐢𝐧𝐠 °˖✧           \n")
    var choice = readLine("To write a tune, press 1 " +
                          "\nTo read a tune from a file, press 2:  ")

    // keeps asking until the user inputs something understandable
    while (choice.trim() != "1" && choice.trim() != "2") {
      choice = readLine("This is not a command I understand. 1 or 2?")
    }

    if (choice.trim() == "2") {
      val path = readLine("Choose file: ")
      manager.readTune(path)
    } else {
      piece = start()
      this.run()
    }
  }

  /** Will be directed here if the user chooses to write a tune.
   *  starts by asking some basic information for creating a piece */
  private def start(): Piece = {
    println()
    val title = readLine("Title of your piece: ")
    val composer = readLine("Composer: ")

    println("\nKeys available: C -> C major, G -> G major, D -> D major, A -> A major," +
            " E -> E major, F -> F major, Bb -> B flat major, Eb -> E flat major")

    var key = readLine("Key: ")
    //keeps asking until the given key is defined
    while (!Key.isDefined(key)) {
      println("Unknown key (·•᷄ࡇ•᷅ )ॽ͙ॽ͙ॽ͙")
      key = readLine("Key: ")
    }
    new Piece(title, composer, key)
  }

  private def run(): Unit = {
    ArrayBuffer("T: " + piece.title, "C: " + piece.composer, "K: " + piece.key, "M: 4/4", "L: 1/16").foreach(piece.lines += _)
    println(piece.instructions + "\n")
    var question = readLine("Do you want to add lyrics? yes/no:")
    while(!List("yes", "no").contains(question.trim().toLowerCase)) {
      question = readLine("lyrics? yes? no? :")
    }

    if(question.trim().toLowerCase == "yes") {
      piece.haveLyric = true
    }

    while (!finished) {
      this.compose()
   }
  }

  private def compose(): Any = {
    var command = readLine("Your line of notes 👉 ")
    var lyric = ""
    if (command.isBlank || command.isEmpty) {
      println("Don't leave it blank ヽ(｀⌒´メ)ノ")
    } else {
      command.trim().toLowerCase match {
        case "quit" =>
          finished = true
          piece.goodBye()
        case "save" => {
          if (piece.getRows.nonEmpty) {
            piece.finish()
            manager.saveTune(s"${piece.title}.txt", piece)  // saves the piece only if the piece is not empty
            piece.drawScore()
          }
          finished = true
          piece.goodBye()
        }
        case _ => {
          if (piece.haveLyric) {
          val words =  readLine("Your lyrics 👉")
          lyric += words
          }
          piece.addLine(command,lyric)
        }
      }
    }
  }

 }
