package com.kine.game

import scala.util.Random

final case class World(
    minx: Integer,
    maxx: Integer,
    miny: Integer,
    maxy: Integer
) {
  def random: Point = Point(
    Random.between(minx, maxx),
    Random.between(miny, maxy)
  )
}
