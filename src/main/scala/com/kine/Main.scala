package com.kine

import com.kine.game.EntityType
import com.kine.game.EntityType.Paper
import com.kine.game.EntityType.Rock
import com.kine.game.EntityType.Scissors
import com.kine.game._
import com.kine.geom.Screen
import com.kine.graphics._
import com.kine.windowing._

import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object TimerUtil {
  def apply(something: => Unit): Long = {
    val before = System.currentTimeMillis()
    something
    val after = System.currentTimeMillis()
    after - before
  }
}
object Main {
  def main(args: Array[String]): Unit = {
    System.setProperty("sun.java2d.opengl", "true")
    val title = "Rock Paper Scissors Simulator"
    val screen = Screen(600,600, Dimension(1, 1))

    val world = World(Dimensions(0d, 0d, 1d, 1d))
    val game = Game(world, screen)

    setupGame(game)

    showMainWindow(title)(game) { ui =>
      ui.pack()
      ui setDefaultCloseOperation WindowConstants.EXIT_ON_CLOSE
      ui setLocationRelativeTo null
      ui setVisible true
    }
  }

  def setupGame: Game => Unit = (game: Game) => {
    val gameObjects = generateGameObjects(
      333 -> Rock,
      333 -> Paper,
      333 -> Scissors
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

    val updater = Ticker(FPS(60)) {
      game.world.update()
    }
    val repainter = Ticker(FPS(120)) {
      val g = gpanel.getGraphics()
      gpanel.doPaint(g)
      g.dispose()
    }

    val ui = UI(title, panel)

    (fn: Function[UI, Unit]) => {
      SwingUtilities.invokeAndWait(() => fn(ui))
      repainter.start()
      updater.start()
    }

  }
}
