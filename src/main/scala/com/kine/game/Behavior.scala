package com.kine.game

import com.kine.game.World
import com.kine.geom.Point

import scala.reflect.ClassTag

trait Behavior[Own <: Entity, Beats <: Entity](implicit
    val tag: ClassTag[Beats]
) { this: Entity =>
  type Prey = Beats
  def onContact(other: Prey): Own

  var someTarget: Option[Prey] = None
  def destination: (World) => Point = (w) =>
    someTarget match
      case None        => w.random
      case Some(value) => value.location.point

  def maxVelocity = 0.01d

  override def update(world: World): Unit = {
    // move to new location
    this.location = location.copy(
      point = location.point + location.velocity,
      velocity = (destination(world) - location.point) length (maxVelocity)
    )

    // check targets
    val targets: Seq[Prey] =
      world.neighbours[Prey](destination(world))(this.radius)
    if (targets.isEmpty) {
      someTarget = world.closest[Prey](location.point)
    }

    // convert in vicinity
    val preyInRange: Seq[Prey] =
      world.neighbours[Prey](this.location.point)(this.radius)
    for (prey <- preyInRange)
      world(prey) = onContact(prey)

  }
}
