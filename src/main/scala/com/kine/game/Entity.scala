package com.kine.game

trait Entity {
  def update: Unit
  def active: Boolean
  def active_=(b:Boolean):Unit
}
