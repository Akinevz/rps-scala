package com.kine.geom

import java.awt.Dimension

final case class Screen(
    width: Int,
    height: Int,
    world: Dimension = Dimension(1, 1)
) {
  type Coord = (Int, Int)
  type WorldSpace = (Double, Double)
  def dimension: Dimension = Dimension(width, height)

  def xscaling: Double =
    world.width.toDouble / width.toDouble
  def yscaling: Double =
    world.width.toDouble / height.toDouble

  def unapply(coord: Coord): WorldSpace = {
    (
      (coord._1.toDouble) * xscaling,
      (coord._2.toDouble) * yscaling
    )
  }
  def apply(ws: WorldSpace): Coord = {
    (
      (ws._1 / xscaling).toInt,
      (ws._2 / yscaling).toInt
    )
  }
}
