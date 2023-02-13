package com.kine

import java.awt.Window
import com.kine.game.EntityType.{Rock => RockType}
import com.kine.game.Rock
import com.kine.geom._
import com.kine.windowing._

class ImageSuite extends munit.FunSuite {

  test("image is loaded") {
    val appearance = RockType
    assertEquals(appearance.name, "rock")
    println(appearance.resource.get)
  }

  test("image is displayed") {
    import javax.swing._

    val behaviour = RockType

    val imageRenderer = behaviour.renderer
    val e = Rock(Location(Point(10, 10)))

    val childPanel = MainPanel()
    val screen = Screen(50,50)
    val jframe = UI("test", childPanel(screen))
    SwingUtilities.invokeAndWait(() => {
      jframe.pack()
      jframe.setVisible(true)
      jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
    })

    while (jframe.isDisplayable())
      Thread.sleep(1000)
  }
}
