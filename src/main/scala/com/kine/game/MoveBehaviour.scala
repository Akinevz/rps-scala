package com.kine.game

trait MoveBehaviour[T] { this:Behaviour[T] => 
  def canMove: Boolean
  def moveSpeed: Double
  def senseRadius: Double
  def moveTarget: (World) => (Point) => Point
}
