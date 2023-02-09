package com.kine.windowing

import javax.swing._
import java.awt.Graphics
import java.awt.Dimension
import java.awt.LayoutManager

final case class UI(titleString: String, children: JComponent*)
    extends JFrame(titleString) {
  for (child <- children) this add child
}

final case class MainPanel(
    children: JComponent*
) extends JPanel {
  for (child <- children) this add child
}

final case class Dials(

) extends JPanel {

}