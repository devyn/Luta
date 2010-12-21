package devyn.luta.engine.core

import org.newdawn.slick.Graphics

trait BasicComponent {
  def update(dt: Int): Unit
  def render(g: Graphics): Unit
}
