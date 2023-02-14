package com.kine.game

import java.awt.Graphics

trait Drawable {
  def draw(g: Graphics): Unit
}
