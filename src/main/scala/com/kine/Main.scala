package com.kine

import java.awt.Dimension
import javax.swing.SwingUtilities
import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.JFrame
import javax.swing.WindowConstants

import com.kine.windowing._
import com.kine.game._

import com.kine.windowing.{UI, MainPanel}
import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val title = "Rock Paper Scissors Simulator"

    showMainWindow(title) { ui =>
      ui setLocationRelativeTo null
      ui setDefaultCloseOperation WindowConstants.EXIT_ON_CLOSE
      ui.pack()
      ui setVisible true
    }
  }
  def generateEntity: (World) => GameObject = (world) =>
    Random.between(0, 3) match
      case 0 => Scissors(world)
      case 1 => Rock(world)
      case 2 => Paper(world)

  def showMainWindow(title: String) = {
    val map = World(0, 100, 0, 100)
    val entities: Seq[GameObject] = 1 to 50 map (_ => generateEntity(map))
    val drawManager = DrawManager()
    val panel = MainPanel(GamePanel(drawManager))
    val ui = UI(title, panel, Dials())
    (fn: Function[UI, Unit]) => SwingUtilities.invokeLater(() => fn(ui))
  }
}
