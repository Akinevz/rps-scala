package com.kine.windowing

import com.kine.Settings
import com.kine.game.World
import com.kine.geom.Screen

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.LayoutManager
import javax.swing._

/** Make any JPanel auto add its components
  *
  * @param children
  */
trait JParent(children: JComponent*) { this: JPanel =>
  for (child <- children) this add child
}
trait JBoxLayout(axis: Integer) { this: JPanel =>
  this.setLayout(new BoxLayout(this, axis))
}

final case class UI(titleString: String, children: JComponent*)
    extends JFrame(titleString) {
  for (child <- children) this add child
  this setResizable false
}

final case class MainPanel(
    children: JComponent*
)(screen: Screen)
    extends JPanel
    with JParent(children: _*)
    with JBoxLayout(BoxLayout.Y_AXIS) {
  this setPreferredSize screen.dimension
  this setMinimumSize screen.dimension
}
final case class Dials(
    settings: Settings,
    children: JComponent*
) extends JPanel
    with JBoxLayout(BoxLayout.Y_AXIS)
    with JParent(children: _*)
