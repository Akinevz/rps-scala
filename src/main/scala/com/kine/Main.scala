package com.kine

import java.awt.Dimension
import javax.swing.SwingUtilities
import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.JFrame
import javax.swing.WindowConstants

import com.kine.windowing._
import com.kine.game._

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

import com.kine.game.EntityType
import com.kine.game.EntityType.Rock
import com.kine.game.EntityType.Paper
import com.kine.game.EntityType.Scissors
import com.kine.graphics._
import com.kine.geom.Screen

object Main {
  def main(args: Array[String]): Unit = {
    val title = "Rock Paper Scissors Simulator"
    val worldNormDim = Dimension(1, 1)
    val screen = Screen(800, 800, worldNormDim)

    val world = World(worldNormDim)
    val game = Game(world, screen)

    setupGame(game)

    showMainWindow(title)(game) { ui =>
      ui setLocationRelativeTo null
      ui setDefaultCloseOperation WindowConstants.EXIT_ON_CLOSE
      ui.pack()
      ui setVisible true
    }
  }

  def setupGame: Game => Unit = (game: Game) => {
    val gameObjects = generateGameObjects(
      33 -> Rock,
      33 -> Paper,
      33 -> Scissors
    ) foreach (entity => game.world instantiate entity)
  }

  def generateGameObjects[F <: EntityType](tuples: (Int, F)*) = {
    for ((count, entityType) <- tuples)
      yield for (_ <- 1 to count)
        yield entityType
  }.flatten

  def showMainWindow(title: String)(game: Game) = {
    import com.kine.game._

    val gpanel = GamePanel(game)
    val panel = MainPanel(gpanel)(game.screen)

    val ui = UI(title, panel)
    (fn: Function[UI, Unit]) => SwingUtilities.invokeLater(() => fn(ui))
  }
}
