package com.kine.game

case class Point(x: Double, y: Double)

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
