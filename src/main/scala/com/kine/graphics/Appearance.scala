package com.kine.graphics

import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import scala.util.Try

trait Appearance { 
  def name: String
  def base: File = File(this.getClass().getResource("/rps/").toURI())
  def image: Try[BufferedImage] = Try(
    ImageIO.read(File(base, name))
  )
}

case object RockAppearance extends Appearance{

  override def name: String = "rock.jpg"
}
case object PaperAppearance extends Appearance{

  override def name: String = "paper.jpg"
}
case object ScissorsAppearance extends Appearance{

  override def name: String = "scissors.jpg"
}