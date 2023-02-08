package com.kine.game

trait Game {
  def drawables: List[Drawable]
  def entities: List[GameObject]
  def ecs: EntityComponentSystem
}
