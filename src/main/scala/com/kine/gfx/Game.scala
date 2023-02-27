package com.kine.gfx

import com.kine.geom.Screen
import com.kine.gfx.Drawable

import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel
import com.kine.game.World
import com.kine.game.EntityType
import com.kine.game.Scissors
import com.kine.game.Paper
import com.kine.game.Rock

class Game(val world: World, val screen: Screen) extends Drawable {

  val rock = EntityType.Rock.renderer(screen)
  val paper = EntityType.Paper.renderer(screen)
  val scissors = EntityType.Scissors.renderer(screen)

  override def draw(g: Graphics): Unit = {
    for (entity <- world.all.clone()) {
      val renderer = entity match
        case Rock(_)     => rock
        case Paper(_)    => paper
        case Scissors(_) => scissors

      renderer(entity).draw(g)
    }
  }

}
