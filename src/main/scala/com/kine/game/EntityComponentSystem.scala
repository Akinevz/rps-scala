package com.kine.game

trait EntityComponentSystem {
  def entities: Entities
  def update(): Unit
}
