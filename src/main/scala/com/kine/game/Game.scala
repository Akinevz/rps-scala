package com.kine.game

import com.kine.geom.Screen
import com.kine.graphics.Drawable

import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class Game(val world: World, val screen: Screen) extends Drawable {

  override def draw(g: Graphics): Unit = {
    for (entity <- world.all) {
      val renderer = EntityType.of(entity).renderer
      renderer(entity).draw(g)
    }
  }

}
