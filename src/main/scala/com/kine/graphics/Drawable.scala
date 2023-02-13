package com.kine.graphics

import java.awt.Graphics

trait Drawable {
  def draw(g: Graphics): Unit
}
