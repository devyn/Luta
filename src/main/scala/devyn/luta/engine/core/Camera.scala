package devyn.luta.engine.core

import org.newdawn.slick.{GameContainer, Graphics}

class Camera(var gc: GameContainer,
             var speed: Float,
             var z: Float)
{
  var x, y: Float = 0
  var track: Option[Trackable] = None
  var zTarget: Option[Float] = None

  def update(dt: Int) {
    val dtm = dt / 1000f
    track foreach {
      t =>
	x += (t.x - x) * dtm * speed
        y += (t.y - y) * dtm * speed
    }
    zTarget foreach { zt => z += (zt - z) * dtm * speed }
  }

  def adjust(g: Graphics, f: Float)(b: Graphics => Unit): Unit = {
    g.pushTransform
    g.translate(-(x*f*z - gc.getWidth  / 2f),
		-(y*f*z - gc.getHeight / 2f))
    g.scale(z, z)
    b(g)
    g.popTransform
  }

  def adjust(g: Graphics)(b: Graphics => Unit): Unit = adjust(g, 1.0f)(b)
}
