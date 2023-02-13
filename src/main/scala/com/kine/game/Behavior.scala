package com.kine.game

import com.kine.game.World
import com.kine.geom.Point

import scala.reflect.ClassTag

trait Behavior[Own <: Entity, Beats <: Entity](implicit
    val tag: ClassTag[Beats]
) { this: Entity =>
  type Prey = Beats
  def onContact(other: Prey): Own

  var destination: Point = null

  def maxVelocity = 5d

  override def update(world: World): Unit = {
    // move aimlessly
    if (destination == null)
      destination = world.random

    // move to new location
    this.location = location.copy(
      point = location.point + location.velocity,
      velocity = (destination - location.point) length (maxVelocity)
    )

    // check targets
    val targets: Seq[Prey] =
      world.neighbours[Prey](this.destination)(this.radius)
    if (targets.isEmpty) {
      val newDest = world.closest[Prey](world.random)
      this.destination = newDest.location.point
    }

    // convert in vicinity
    val preyInRange: Seq[Prey] =
      world.neighbours[Prey](this.location.point)(this.radius)
    for (prey <- preyInRange)
      world(prey) = onContact(prey)

  }
}
