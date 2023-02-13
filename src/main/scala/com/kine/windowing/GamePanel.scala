package com.kine.windowing
import javax.swing.JPanel
import java.awt.Graphics
import java.awt.Dimension
import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.color.ColorSpace
import com.kine.game.Game

final case class GamePanel(game: Game) extends JPanel {

  def makeFrame(op: (Graphics) => Unit): BufferedImage = {
    val dim = game.screen.dimension
    val buffer = BufferedImage(dim.width, dim.height, ColorSpace.TYPE_RGB)
    val graphics = buffer.getGraphics()
    op(graphics)
    graphics.dispose()
    buffer
  }
  override def paint(g: Graphics): Unit = {
    super.paint(g)
    val frame = makeFrame(game.draw)
    g.drawImage(frame, 0, 0, getWidth(), getHeight(), null)
  }
}
