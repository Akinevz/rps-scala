package com.kine.game

import scala.collection.mutable.ArrayBuffer
import com.kine._
import com.kine.geom._
import com.kine.game._

trait ECS { this: World =>
  val entities: Pool[Entity] = Pool()
  def update(): Unit = {
    for (entity <- entities) {
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
