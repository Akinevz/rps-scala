package com.kine.windowing

import java.awt.Graphics

trait Drawable {
  def draw(g: Graphics): Unit
}
