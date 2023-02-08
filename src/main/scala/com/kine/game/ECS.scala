package com.kine.game

import scala.collection.mutable.ArrayBuffer

class ECS extends EntityComponentSystem{
  val entities: Pool[GameObject] = Pool()

  def instantiate(go: GameObject): GOId = entities += go

  def gc(): Unit = entities.buffer = entities.buffer.filter(s => s.active)

  def remove(goid: GOId): Unit = entities.buffer(goid).active = false

  def update(): Unit = entities.buffer.filter(_.active).foreach(_.update)

}
