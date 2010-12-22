package devyn.luta.engine.test

import devyn.luta.engine.core.{Scene,BasicComponent,Trackable}
import scala.util.Random
import org.newdawn.slick.Graphics

class Ball(scene: Scene)
      extends BasicComponent
         with Trackable
{
  var x, y: Float = 10
  var acc: Int = 0
  val r = new Random

  def update(dt: Int) {
    if (acc > 1000) {
      acc = 0
      x = r.nextInt(5)+10
      y = r.nextInt(5)+10
    } else {
      acc += dt
    }
  }

  def render(g: Graphics) {
    scene.camera.adjust(g) {
      gP =>
	// Draw the circle anti-aliased.   It is necessary to draw the
	// outline of the circle after filling it; the fill alone does
	// not get anti-aliased.
	gP.setAntiAlias(true)
        gP.fillOval(x-1, y-1, 2, 2)
        gP.drawOval(x-1, y-1, 2, 2)

        // Draw surroundings.
        gP.drawOval(10, 10, 1, 1)
        gP.drawOval(10, 15, 1, 1)
        gP.drawOval(15, 15, 1, 1)
	gP.drawOval(15, 10, 1, 1)
    }
    // Display camera position. Temporary; for debug only.
    g.drawString("x: " + scene.camera.x, 50, 50)
    g.drawString("y: " + scene.camera.y, 50, 65)
    g.drawString("z: " + scene.camera.z, 50, 80)
  }
}
