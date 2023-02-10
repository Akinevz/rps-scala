package com.kine.game

import java.io.File

trait Behaviour[T] extends Appearance with MoveBehaviour[T] {
  override def canMove: Boolean = true
  override def moveSpeed: Double = 5.0d
  override def base: File = File(
    this.getClass().getResource("/rps/").toURI()
  )
}
