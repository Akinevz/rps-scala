package com.kine.game

import javax.swing.JPanel
import com.kine.geom.Screen
import com.kine.graphics.Drawable
import java.awt.Graphics
import java.awt.Dimension

class Game(val world: World, val screen: Screen) extends Drawable {

  override def draw(g: Graphics): Unit = {
    for (entity <- world.all) {
      val renderer = EntityType.of(entity).renderer
      renderer(entity).draw(g)
    }
  }

}
