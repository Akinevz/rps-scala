package com.kine.gfx

import java.awt.Graphics

trait Drawable {
  def draw(g: Graphics): Unit
}
