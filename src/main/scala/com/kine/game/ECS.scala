package com.kine.game

import scala.collection.mutable.ArrayBuffer
class ECS(val entities: Pool[Entity] = Pool()) {
  def update(): Unit = entities.buffer.filter(_.active).foreach(_.update)
  def instantiate(go: Entity): GOId = entities += go
  def remove(goid: GOId): Unit = entities.buffer(goid).active = false
  def gc(): Unit = entities.buffer = entities.buffer.filter(s => s.active)
}
