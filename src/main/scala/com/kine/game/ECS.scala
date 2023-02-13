package com.kine.game

import com.kine._
import com.kine.game._
import com.kine.geom._

import scala.collection.mutable.ArrayBuffer

trait ECS { this: World =>
  val entities: Pool[Entity] = Pool()

  def update(): Unit = {
    for (i <- 0 until entities.size) {
      val entity = entities(i)
      entity.update(this)
    }
  }

  def instantiate(go: EntityType): EId =
    entities += {
      go match
        case EntityType.Rock     => Rock(Location(random))
        case EntityType.Paper    => Paper(Location(random))
        case EntityType.Scissors => Scissors(Location(random))
    }
  def kill(goid: EId): Unit = entities.buffer(goid).active = false
  def active = entities.buffer.filter(s => s.active)
}
