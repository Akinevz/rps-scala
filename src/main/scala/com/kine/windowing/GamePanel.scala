package com.kine.windowing
import javax.swing.JPanel
import java.awt.Graphics
import com.kine.game.Game

final case class GamePanel(game:Game) extends JPanel {
    override def paint(g:Graphics):Unit = {
        super.paint(g)
        for(d <- game.drawables) {
           d.draw(g)
        }
    }
}
