
import com.kine.windowing._
import java.awt.Dimension
import javax.swing.JPanel
import scala.swing._
import munit.Clue.generate
import javax.swing.JLabel
import com.kine.game._
// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
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
    val window = UI("test", MainPanel()(new JLabel("hello world")))
    window.pack()
    window.setVisible(true)
    assertEquals(window.isVisible(), true)
  }

  test("window loads game") {
    val game = new ECS()
    val gamePanel = GamePanel(game)
    val window = UI("test", gamePanel)
    window.pack()
    window.setVisible(true)
    
  }
}
