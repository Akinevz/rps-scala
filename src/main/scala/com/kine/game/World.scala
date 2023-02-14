package com.kine.game

import com.kine.geom._

import java.awt.Dimension
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag
import scala.util.Random

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

  def all: ArrayBuffer[Entity] = this.entities.buffer

  def neighbours[E](
      point: Point
  )(distance: Double)(implicit tag: ClassTag[E]): Seq[E] = {
    if (point == null) return neighbours(random)(distance)

    all
      .filter(e => (e.location distanceTo point) < distance)
      .sortBy(e => e.location distanceTo point)
      .filter(e => tag.unapply(e).isDefined)
      .map(e => e.asInstanceOf[E])
      .toSeq
  }

  def closest[E <: Entity](point: Point)(implicit tag: ClassTag[E]): Option[E] = {
    val shortestDistance = all
      .filter(e => tag.unapply(e).isDefined)
      .sortBy(e => e.location distanceTo point)
      .headOption
    shortestDistance.asInstanceOf[Option[E]]
  }

  def update(e: Entity, u: Entity): Unit = {
    val indexof: EId = all indexOf e
    entities.buffer(indexof) = u
  }
}

