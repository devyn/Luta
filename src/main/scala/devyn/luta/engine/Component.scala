package devyn.luta.engine

import org.newdawn.slick.Graphics

trait Component {
  def update(dt: Int): Unit
  def render(g: Graphics): Unit
}
