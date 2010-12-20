package devyn.luta

import devyn.luta.engine.Scene
import org.newdawn.slick.AppGameContainer

object Main {
  def main(args: Array[String]) {
    val scene = Scene("Test!") { (s, gc) => }
    val gc = new AppGameContainer(scene, 800, 600, false)

    gc.setTargetFrameRate(60)
    gc.setVSync(true)
    gc.setSmoothDeltas(true)

    gc.start
  }
}
