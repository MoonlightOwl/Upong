package totoro.upong.screen.gameplay

import totoro.upong.{Assets, Config, Upong}
import totoro.upong.screen.GameScreen

/**
  * All ping-pong gameplay goes here.
  * @param game the parent game object
  */

class PingPongScreen(game: Upong) extends GameScreen {
  override def keyTyped(character: Char): Boolean = { println(character); true }

  override def render(delta: Float): Unit = {
    game.batch.begin()
    game.batch.draw(Assets.Tex.Background, 0, 0, 0, 0, Config.Width, Config.Height)
    game.batch.end()
  }
}
