package com.kine.game

import scala.util.Random
import java.awt.Dimension

final case class Dimensions(
    minx: Double,
    maxx: Double,
    miny: Double,
    maxy: Double
)
final case class World(
    dimensions: Dimensions,
    entities: Entities
) {
  def random: Point = Point(
    Random.between(dimensions.minx, dimensions.maxx),
    Random.between(dimensions.miny, dimensions.maxy)
  )
}

object World {
  def apply(dim: Dimension) = new World(Dimensions(0, dim.width, 0, dim.height), _:Entities)
}
