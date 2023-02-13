package com.kine.game

import com.kine.game.{Paper => paper}
import com.kine.game.{Rock => rock}
import com.kine.game.{Scissors => scissors}
import com.kine.graphics.Drawable

import java.awt.Graphics
import java.awt.Image
import java.awt.image.ImageObserver
import java.io.File
import java.io.InputStream
import javax.imageio.ImageIO
import scala.util.Try

sealed trait EntityType {
  def renderer: (Entity) => Drawable
  def name: String
  def resource = Try(
    (this.getClass().getResource("/rps/" + name + ".jpg"))
  )
}

object EntityType {

  def of(e: Entity): EntityType = {
    e match
      case rock(_)     => Rock
      case paper(_)    => Paper
      case scissors(_) => Scissors
  }

  case object Rock extends EntityType {
    override def name: String = "rock"
    override def renderer = {
      val image = ImageIO.read(resource.get)
      (e: Entity) =>
        (g: Graphics) => {
          g.drawImage(
            image,
            e.location.point.x.toInt,
            e.location.point.y.toInt,
            10,
            10,
            null
          )
        }
    }
  }

  case object Paper extends EntityType {
    override def name: String = "paper"
    override def renderer = {
      val image = ImageIO.read(resource.get)
      (e: Entity) =>
        (g: Graphics) => {
          g.drawImage(
            image,
            e.location.point.x.toInt,
            e.location.point.y.toInt,
            10,
            10,
            null
          )
        }
    }
  }

  case object Scissors extends EntityType {
    override def name: String = "scissors"
    override def renderer = {
      val image = ImageIO.read(resource.get)
      (e: Entity) =>
        (g: Graphics) => {
          g.drawImage(
            image,
            e.location.point.x.toInt,
            e.location.point.y.toInt,
            10,
            10,
            null
          )
        }
    }
  }
}
