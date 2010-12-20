package devyn.luta.engine

import org.newdawn.slick.{BasicGame,GameContainer,Graphics}

class Scene(name: String) extends BasicGame(name) {
  //val components = ListBuffer[Component]

  // please override
  def init(gc: GameContainer) {}

  def update(gc: GameContainer, dt: Int) {
    // TODO: use components
  }

  def render(gc: GameContainer, g: Graphics) {
    // TODO: use components
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
