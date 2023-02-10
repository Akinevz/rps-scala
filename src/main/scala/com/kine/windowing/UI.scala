package com.kine.windowing

import javax.swing._
import java.awt.Graphics
import java.awt.Dimension
import java.awt.LayoutManager
import com.kine.game.World
import cats.instances.set
import com.kine.Settings

trait JParent(children: JComponent*) { this: JComponent =>
  for (child <- children) this add child
}

trait AutoRegister(settings: Settings) { this: JComponent =>
  // settings.register(this)
  ???
}

final case class UI(titleString: String, children: JComponent*)
    extends JFrame(titleString) {
  for (child <- children) this add child
}

final case class MainPanel(
    settings: Settings,
    children: JComponent*
) extends JPanel
    with JParent(children: _*)
    with AutoRegister(settings)

trait LayoutBox(axis: Integer) { this: JPanel =>
  this.setLayout(new BoxLayout(this, axis))
}
final case class Dials(
    settings: Settings,
    children: JComponent*
) extends JPanel
    with LayoutBox(BoxLayout.Y_AXIS)
    with JParent(children: _*)
    with AutoRegister(settings)
