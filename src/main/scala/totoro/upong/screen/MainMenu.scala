package totoro.upong.screen

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import totoro.upong.ui.Terminal
import totoro.upong.{Assets, Config}

class MainMenu {
  private val terminal: Terminal = new Terminal(19, 14, Assets.Font.Menu)

  terminal.println("Ohayou!")
  terminal.println("This is Upong, mul-tiplayer ping-pong game. Welcome and  enjoy!")
  terminal.println()
  terminal.print("> ")

  def update(): Unit = {
    terminal.update()
  }

  def render(batch: SpriteBatch): Unit = {
    batch.draw(Assets.Tex.Kururi1, 20, 0)
    batch.draw(Assets.Tex.Logo, Config.Width / 2 - 160, Config.Height - 160)
    terminal.draw(batch, Config.Width / 2 - 20, 480)
  }
}
