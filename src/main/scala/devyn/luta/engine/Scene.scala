package devyn.luta.engine

import org.newdawn.slick.{BasicGame,GameContainer,Graphics}
import scala.collection.mutable.ListBuffer

abstract class Scene(name: String) extends BasicGame(name) {
  val components = new ListBuffer[Component]

  // please override
  def init(gc: GameContainer): Unit

  def update(gc: GameContainer, dt: Int) =
    components foreach {
      _.update(dt)
    }

  def render(gc: GameContainer, g: Graphics) =
    components foreach { x =>
      g.pushTransform

      x.render(g)

      g.popTransform
    }
}

object Scene {
  def apply(name: String)(_init: (Scene, GameContainer) => Unit): Scene =
    new Scene(name) {
      override def init(gc: GameContainer) {
	_init(this, gc)
      }
    }
}
