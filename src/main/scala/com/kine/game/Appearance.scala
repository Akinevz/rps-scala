package com.kine.game

import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import scala.util.Try

trait Appearance { 
  def name: String
  def base: File
  def image: Try[BufferedImage] = Try(
    ImageIO.read(File(base, name))
  )
}
