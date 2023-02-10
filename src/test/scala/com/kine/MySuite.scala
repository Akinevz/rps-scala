package com.kine

import com.kine.windowing._
import java.awt.Dimension
import javax.swing.JPanel
import javax.swing.JLabel
import com.kine.game._
import com.kine.Settings

class MySuite extends munit.FunSuite {
  test("window size is respected") {
    val dim = new Dimension(200, 200)
    val window = UI(
      "test",
      new JPanel()
    )
    window.setPreferredSize(dim)
    window.pack()
    assertEquals(window.size(), dim)
  }

  test("window opens") {
    val window = UI("test")
    window.pack()
    window.setVisible(true)
    assertEquals(window.isVisible(), true)
  }

}
