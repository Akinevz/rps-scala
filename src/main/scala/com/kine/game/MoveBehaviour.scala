package com.kine.game

trait MoveBehaviour { this:Behaviour => 
  def canMove: Boolean
  def moveSpeed: Double
  def moveTarget: (World) => Point
}
