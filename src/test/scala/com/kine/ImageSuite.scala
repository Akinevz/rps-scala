package com.kine

import com.kine.game.Rock
import java.awt.Window

class ImageSuite extends munit.FunSuite {
  test("image is loaded") {
    val behaviour = Rock
    assertEquals(behaviour.name, "rock.jpg")
    println(behaviour.base)
    println(behaviour.image.get)
  }

  test("image is displayed") {
    import javax.swing._

    val behaviour = Rock

    val image = behaviour.image.get
    val jframe = new JFrame("testing")
    val jpanel = new JPanel()
    val layout = new BoxLayout(jpanel, BoxLayout.Y_AXIS)
    val icon = new ImageIcon(image)
    val text = behaviour.base.toString()
    val label = new JLabel(text, icon, 0)

    jpanel.add(label)
    jframe.add(jpanel)

    SwingUtilities.invokeAndWait(() => {
      jframe.pack()
      jframe.setVisible(true)
      jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    })

    while (jframe.isDisplayable())
      Thread.sleep(1000)
  }
}
