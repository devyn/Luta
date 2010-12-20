package devyn.luta.engine.test

import devyn.luta.engine.Component
import scala.math._
import org.newdawn.slick.Graphics

class Ball extends Component {
  var x, y: Float = 300
  var acc: Int = 0

  def update(dt: Int) {
    // Increment the accumulator.  Possible error when the accumulator
    // steps over the maximum value for Int.
    acc += dt

    // Use sine and cosine functions to make a perfect circular orbit.
    x = sin(acc.toDouble / 500).toFloat * 100 + 300
    y = cos(acc.toDouble / 500).toFloat * 100 + 300
  }

  def render(g: Graphics) {
    // Draw  the  circle  anti-aliased.  It is necessary  to  draw the
    // outline of the circle after filling it; the fill alone does not
    // get anti-aliased.
    g.setAntiAlias(true)
    g.fillOval(x, y, 50, 50)
    g.drawOval(x, y, 50, 50)
  }
}
