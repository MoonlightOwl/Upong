package totoro.upong

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import totoro.upong.ui.Terminal

/**
  * Central game class.
  * Is responsible for game lifecycle steps.
  */

class Upong extends ApplicationAdapter {
  var batch: SpriteBatch = _
  var menuTerminal: Terminal = _

  override def create(): Unit = {
    batch = new SpriteBatch()
    menuTerminal = new Terminal(19, 14, Assets.Font.Menu)
  }

  override def render(): Unit = {
    // update scene
    menuTerminal.update()

    // render scene
    batch.begin()
    batch.draw(Assets.Tex.MenuBackground, 0, 0, 0, 0, Config.Width, Config.Height)
    batch.draw(Assets.Tex.Kururi1, 20, 0)
    batch.draw(Assets.Tex.Logo, Config.Width / 2 - 160, Config.Height - 160)
    menuTerminal.draw(batch, Config.Width / 2 - 20, 480)
    batch.end()
  }

  override def dispose(): Unit = {
    batch.dispose()
    Assets.dispose()
  }
}
