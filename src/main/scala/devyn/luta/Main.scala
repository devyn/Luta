package devyn.luta

import devyn.luta.engine.core.Scene
import org.newdawn.slick.AppGameContainer
import devyn.luta.engine.test.Ball

object Main {
  def main(args: Array[String]) {
    val scene = Scene("Test!") { 
      (s, gc) =>
        val b = new Ball(s)
        s.components += b
        s.camera.track = Some(b)
    }
    val gc = new AppGameContainer(scene, 800, 600, false)

    gc.setTargetFrameRate(60)
    gc.setVSync(true)
    gc.setSmoothDeltas(true)

    gc.start
  }
}
