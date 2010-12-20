package devyn.luta.engine.test

import devyn.luta.engine.Component
import scala.math._
import org.newdawn.slick.Graphics

class Ball extends Component {
  var x, y: Float = 300
  var acc: Int = 0

  def update(dt: Int) {
    acc += dt
    x = sin(acc.toDouble / 500).toFloat * 100 + 300
    y = x
  }

  def render(g: Graphics) {
    g.setAntiAlias(true)
    g.fillOval(x, y, 50, 50)
    g.drawOval(x, y, 50, 50)
  }
}
