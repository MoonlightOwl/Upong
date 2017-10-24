package totoro.upong.screen.gameplay

import com.badlogic.gdx.Input.Keys
import totoro.upong.{Assets, Config, Upong}
import totoro.upong.screen.GameScreen
import totoro.upong.screen.menu.MainMenuScreen

/**
  * All ping-pong gameplay goes here.
  * @param game the parent game object
  */

class PingPongScreen(game: Upong) extends GameScreen {
  override def keyDown(keycode: Int): Boolean = {
    keycode match {
      case Keys.ESCAPE =>
        game.setGameScreen(new MainMenuScreen(game))
        true
      case _ => false
    }
  }

  override def render(delta: Float): Unit = {
    game.batch.begin()
    game.batch.draw(Assets.Tex.Background, 0, 0, 0, 0, Config.Width, Config.Height)
    game.batch.end()
  }
}
