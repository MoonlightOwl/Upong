package totoro.upong

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import totoro.upong.screen.MainMenu

/**
  * Central game class.
  * Is responsible for game lifecycle steps.
  */

class Upong extends ApplicationAdapter {
  var batch: SpriteBatch = _
  var menu: MainMenu = _

  override def create(): Unit = {
    batch = new SpriteBatch
    menu = new MainMenu
  }

  override def render(): Unit = {
    // update scene
    menu.update()
    // render scene
    batch.begin()

    // background
    batch.draw(Assets.Tex.Background, 0, 0, 0, 0, Config.Width, Config.Height)

    // screens
    menu.render(batch)

    batch.end()
  }

  override def dispose(): Unit = {
    batch.dispose()
    Assets.dispose()
  }
}
