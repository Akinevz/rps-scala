package com.kine.game

import java.io.File

sealed trait Behaviour extends Appearance with MoveBehaviour {
  override def canMove: Boolean = true
  override def moveSpeed: Double = 5.0d
  override def base: File = File(
    this.getClass().getResource("/rps/").toURI()
  )
}

case object Rock extends Behaviour {
  def name: String = "rock.jpg"
  def moveTarget: World => Point = ???
}
case object Paper extends Behaviour {
  def name: String = "paper.jpg"
  def moveTarget: World => Point = ???

}
case object Scissors extends Behaviour {
  def name: String = "scissors.jpg"
  def moveTarget: World => Point = ???
}
