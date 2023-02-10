package com.kine.game

trait Entity {
  var active: Boolean = true
  var location: Location

  def update: Unit =
    if (active)
      location = location.copy(point = location.point + location.velocity)
    else {}
  def behaviour: Behaviour[_]
}

// case class Rock(override val behaviour: Behaviour[Rock]) extends Entity
// case class Paper(override val behaviour: Behaviour[Paper]) extends Entity
// case class Scissors(override val behaviour: Behaviour[Scissors]) extends Entity
