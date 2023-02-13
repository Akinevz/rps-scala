package com.kine.game

import com.kine.game._
import com.kine.geom._

sealed trait Entity {
  def location: Location
  def location_=(location: Location): Unit
  def radius: Double = 0.01d

  var active: Boolean = true

  def update(world: World): Unit
}

case class Rock(override var location: Location)
    extends Entity
    with Behavior[Rock, Scissors] {
  override def onContact(other: Scissors): Rock = Rock(other.location)
}
case class Paper(override var location: Location)
    extends Entity
    with Behavior[Paper, Rock] {
  override def onContact(other: Rock): Paper = Paper(other.location)
}
case class Scissors(override var location: Location)
    extends Entity
    with Behavior[Scissors, Paper] {
  override def onContact(other: Paper): Scissors = Scissors(other.location)
}
