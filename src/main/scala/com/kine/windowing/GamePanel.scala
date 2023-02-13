package com.kine.windowing
import com.kine.game.Game

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.color.ColorSpace
import java.awt.image.BufferedImage
import javax.swing.JPanel

final case class GamePanel(game: Game) extends JPanel {

  def makeFrame(all: (Graphics) => Unit): BufferedImage = {
    val dim = game.screen.dimension
    val buffer = BufferedImage(dim.width, dim.height, ColorSpace.TYPE_RGB)
    val graphics = buffer.getGraphics()
    all(graphics)
    graphics.dispose()
    buffer
  }
  override protected def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    val frame = makeFrame(game.draw)
    g.drawImage(frame, 0, 0, getWidth(), getHeight(), null)
  }
}
