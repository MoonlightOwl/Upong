package totoro.upong.screen

import com.badlogic.gdx.{InputProcessor, Screen}

/**
  * Convenience implementation of two interfaces: Screen and InputProcessor
  */

class GameScreen extends Screen with InputProcessor{
  override def show(): Unit = {}

  override def render(delta: Float): Unit = {}

  override def resume(): Unit = {}

  override def pause(): Unit = {}

  override def hide(): Unit = {}

  override def resize(width: Int, height: Int): Unit = {}

  override def dispose(): Unit = {}

  override def keyUp(keycode: Int): Boolean = { false }

  override def keyTyped(character: Char): Boolean = { false }

  override def mouseMoved(screenX: Int, screenY: Int): Boolean = { false }

  override def touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean = { false }

  override def touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean = { false }

  override def scrolled(amount: Int): Boolean = { false }

  override def touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean = { false }

  override def keyDown(keycode: Int): Boolean = { false }
}
