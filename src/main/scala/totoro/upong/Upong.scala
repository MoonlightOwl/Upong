package totoro.upong

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import totoro.upong.screen.MainMenuScreen

/**
  * Central game class.
  * Is responsible for game lifecycle steps.
  */

class Upong extends Game {
  var batch: SpriteBatch = _

  override def create(): Unit = {
    batch = new SpriteBatch
    this.setScreen(new MainMenuScreen(this))
  }

  override def render(): Unit = {
    super.render()
  }

  override def dispose(): Unit = {
    batch.dispose()
    Assets.dispose()
  }
}
