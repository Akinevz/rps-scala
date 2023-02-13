package com.kine.game

import scala.util.Random
import java.awt.Dimension
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

import com.kine.geom._

final case class Dimensions(
    minx: Double,
    miny: Double,
    maxx: Double,
    maxy: Double
)
class World(board: Dimensions) extends ECS {

  def width: Double = board.maxx - board.minx
  def height: Double = board.maxy - board.miny

  def random: Point = Point(
    Random.between(board.minx, board.maxx),
    Random.between(board.miny, board.maxy)
  )

  def all: IndexedSeq[Entity] = this.entities.buffer.toIndexedSeq

  def neighbours[E](
      point: Point
  )(distance: Double)(implicit tag: ClassTag[E]): Seq[E] = {
    if (point == null) return neighbours(random)(distance)

    all.toList
      .sortBy(e => e.location distanceTo point)
      .filter(e => (e.location distanceTo point) < distance)
      .filter(e => tag.unapply(e).isDefined)
      .map(e => e.asInstanceOf[E])
  }

  def closest[E <: Entity](point: Point)(implicit tag: ClassTag[E]): E = {
    val shortestDistance = all
      .filter(e => tag.unapply(e).isDefined)
      .toList
      .sortBy(e => e.location distanceTo point)
      .head
    shortestDistance.asInstanceOf[E]
  }

  def update(e: Entity, u:Entity): Unit = {
    val indexof: EId = all indexOf e
    entities.buffer(indexof) = u
  }
}

object World {
  def apply(dim: Dimension): World = new World(
    Dimensions(0, 0, dim.width, dim.height)
  )
}
