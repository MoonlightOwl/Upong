package totoro.upong.screen

import com.badlogic.gdx.Screen
import totoro.upong.ui.Terminal
import totoro.upong.{Assets, Config, Upong}

/**
  * This class is responsible for main menu processing.
  * @param game the parent game object
  */

class MainMenuScreen(game: Upong) extends Screen {
  private val terminal: Terminal = new Terminal(19, 14, Assets.Font.Menu)

  terminal.println("Ohayou!")
  terminal.println("This is Upong, mul-tiplayer ping-pong game. Welcome and  enjoy!")
  terminal.println()
  terminal.print("> ")

  def render(delta: Float): Unit = {
    terminal.update()

    game.batch.begin()
    game.batch.draw(Assets.Tex.Background, 0, 0, 0, 0, Config.Width, Config.Height)
    game.batch.draw(Assets.Tex.Logo, Config.Width / 2 - 160, Config.Height - 160)
    game.batch.draw(Assets.Tex.Kururi1, 20, 0)
    terminal.draw(game.batch, Config.Width / 2 - 20, 480)
    game.batch.end()
  }

  override def resize(width: Int, height: Int) {}

  override def pause() {}
  override def resume() {}

  override def hide() {}
  override def show() {}

  override def dispose() {}
}
