package com.kine.windowing

import javax.swing._
import java.awt.Graphics
import java.awt.Dimension

final case class UI(titleString: String, children: JComponent*)
    extends JFrame(titleString) {
  for (child <- children) this add child
}

case class MainPanel(
    override val size: Dimension = new Dimension(800, 600)
) extends JPanel {
  def apply(components: JComponent*): MainPanel = {
    for (component <- components) this add component
    this
  }
}

case class Readout(text: String = "") extends JTextField {}
