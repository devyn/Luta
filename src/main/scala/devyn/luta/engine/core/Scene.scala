package devyn.luta.engine.core

import org.newdawn.slick.{BasicGame,GameContainer,Graphics}
import scala.collection.mutable.ListBuffer

abstract class Scene(name: String) extends BasicGame(name) {
  val components = new ListBuffer[BasicComponent]
  var camera: Camera = null

  def init(gc: GameContainer) {
    camera = new Camera(gc, 10, 100)
    setup(gc)
  }

  def setup(gc: GameContainer): Unit

  def update(gc: GameContainer, dt: Int) {
    components foreach {
      _.update(dt)
    }
    camera.update(dt)
  }

  def render(gc: GameContainer, g: Graphics) =
    components foreach { x =>
      g.pushTransform

      x.render(g)

      g.popTransform
    }

  // temporary, for demo purposes
  override def keyPressed(key: Int, c: Char) {
    if (c == 'z')
      camera.zTarget = camera.zTarget map ((_:Float) + 10) orElse Some(camera.z + 10)
    else if (c == 'x')
      camera.zTarget = camera.zTarget map ((_:Float) - 10) orElse Some(camera.z - 10)
  }
}

object Scene {
  def apply(name: String)(_init: (Scene, GameContainer) => Unit): Scene =
    new Scene(name) {
      def setup(gc: GameContainer) = _init(this, gc)
    }
}
