package com.kine.game

import com.kine.geom.Screen
import com.kine.graphics.Drawable

import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class Game(val world: World, val screen: Screen) extends Drawable {

  val rock = EntityType.Rock.renderer(screen)
  val paper = EntityType.Paper.renderer(screen)
  val scissors = EntityType.Scissors.renderer(screen)
  
  override def draw(g: Graphics): Unit = {
    for (entity <- world.all.clone()) {
      val renderer = entity match
        case Rock(_) => rock
        case Paper(_) => paper
        case Scissors(_) => scissors
      
      renderer(entity).draw(g)
    }
  }

}
