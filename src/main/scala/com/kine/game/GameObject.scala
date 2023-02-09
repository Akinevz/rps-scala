package com.kine.game

sealed trait GameObject(var loc: Point) extends Entity {
  var active = true
  var velocity = Point(0, 0)
  def update: Unit = loc = loc + velocity
}

final case class Scissors(map: World) extends GameObject(map.random)
final case class Rock(map: World) extends GameObject(map.random)
final case class Paper(map: World) extends GameObject(map.random)
