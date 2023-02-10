package com.kine.game

trait Entity {
  def update: Unit
  var active: Boolean
  var location: Point
  var velocity: Point
}
