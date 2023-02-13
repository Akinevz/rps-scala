package com.kine.game

import com.kine.game.World

trait StunBehavior { this: Entity =>
  var stunDuration: Int = 0
  def stun: Unit = stunDuration = 5
  def isStunned: Boolean = stunDuration > 0
}
