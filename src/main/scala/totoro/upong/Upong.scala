package totoro.upong

import com.badlogic.gdx.{Game, Gdx}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import totoro.upong.screen.GameScreen
import totoro.upong.screen.menu.MainMenuScreen

/**
  * Central game class.
  * Is responsible for game lifecycle steps.
  */

class Upong extends Game {
  var batch: SpriteBatch = _

  override def create(): Unit = {
    batch = new SpriteBatch
    setGameScreen(new MainMenuScreen(this))
  }

  def setGameScreen(screen: GameScreen): Unit = {
    super.setScreen(screen)
    Gdx.input.setInputProcessor(screen)
  }

  override def render(): Unit = {
    super.render()
  }

  override def dispose(): Unit = {
    batch.dispose()
    Assets.dispose()
  }
}
