package com.kine.geom

case class Point(x: Double, y: Double) {
  def distanceTo(that: Point): Double = {
    val xdist = Math.pow(that.x - this.x, 2)
    val ydist = Math.pow(that.y - this.y, 2)
    Math.sqrt(ydist + xdist)
  }

  def length(dist: Double): Point = {
    val component = this distanceTo Point(0, 0)
    this copy (x = dist * (x / component), y = dist * (y / component))
  }
}

object Point {
  extension (point: Point) {
    def +(other: Point): Point = {
      Point(point.x + other.x, point.y + other.y)
    }
    def -(other: Point): Point = {
      Point(point.x - other.x, point.y - other.y)
    }
  }
}
