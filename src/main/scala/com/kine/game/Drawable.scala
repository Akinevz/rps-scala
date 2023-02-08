package com.kine.game

import javax.swing.JComponent
import java.awt.Graphics

trait Drawable { JComponent =>
  def draw(g: Graphics):Unit
}
