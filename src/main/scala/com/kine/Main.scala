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
    val world = World(Dimension(100, 100))
    val gameObjects = generateGameObjects(99)

    showMainWindow(title) { ui =>
      ui setLocationRelativeTo null
      ui setDefaultCloseOperation WindowConstants.EXIT_ON_CLOSE
      ui.pack()
      ui setVisible true
    }
  }

  def generateGameObjects(count: Integer): (World) => Seq[Entity] = ???
  // (world) => 1 to count map (_ => generateEntity(world))

  def makeBehaviour: Behaviour = Random.between(0, 3) match
    case 0 => Scissors
    case 1 => Rock
    case 2 => Paper

  def showMainWindow(title: String) = {
    import com.kine.game._
    val spawnNumber = 99
    val rules = Rules(
      ???
        // Rule[Scissors].beats(Rule[Paper]),
        // Rule[Paper].beats(Rule[Rock]),
        // Rule[Rock].beats(Rule[Scissors])
      )
    val velocity = 5d
    val settings = Settings(
      rules=rules,
      spawnNumber=spawnNumber,
      velocity=velocity
    )
    val panel = MainPanel(settings)
    val dials = Dials(settings)
    val ui = UI(title, panel, dials)
    (fn: Function[UI, Unit]) => SwingUtilities.invokeLater(() => fn(ui))
  }
}
