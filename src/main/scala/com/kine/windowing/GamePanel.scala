package com.kine.windowing
import javax.swing.JPanel
import java.awt.Graphics
import com.kine.game.Game

final case class GamePanel(drawable: Drawable) extends JPanel {
  override def paint(g: Graphics): Unit = {
    super.paint(g)
    drawable.draw(g)
  }
}
