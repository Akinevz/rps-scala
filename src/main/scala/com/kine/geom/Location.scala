package com.kine.geom

case class Location(point: Point, velocity: Point = Point(0, 0)) {
  def distanceTo(that: Point): Double = point distanceTo that
  def inRange(distance: Double)(that: Point): Boolean = {
    val dist = this distanceTo that
    dist < distance
  }
}
