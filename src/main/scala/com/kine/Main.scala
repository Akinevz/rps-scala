package com.kine

import java.awt.Dimension
import javax.swing.SwingUtilities
import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.JFrame
import javax.swing.WindowConstants

import com.kine.windowing._
import com.kine.game._

import com.kine.windowing.{UI, MainPanel, Readout}
object Main {
  def main(args: Array[String]): Unit = {
    showMainWindow("HTML Explorer") { ui =>
      ui setLocationRelativeTo null
      ui setDefaultCloseOperation WindowConstants.EXIT_ON_CLOSE
      ui.pack()
      ui setVisible true
    }
  }

  def showMainWindow(title: String) = {
    val label = new JLabel("Hello world!")
    val panel = MainPanel()
    val readout = Readout("Test")
    val ui = UI(title, panel(label, readout))
    (fn: Function[UI, Unit]) => SwingUtilities.invokeLater(() => fn(ui))
  }
}
