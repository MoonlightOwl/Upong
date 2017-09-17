package totoro.upong

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Upong extends ApplicationAdapter {
  var batch: SpriteBatch = _
  var menuMatrix: Matrix = _

  override def create(): Unit = {
    batch = new SpriteBatch()
    menuMatrix = new Matrix(19, 14, Assets.Font.Menu)
  }

  override def render(): Unit = {
    batch.begin()
    batch.draw(Assets.Tex.MenuBackground, 0, 0, 0, 0, Config.Width, Config.Height)
    batch.draw(Assets.Tex.Kururi1, 20, 0)
    batch.draw(Assets.Tex.Logo, Config.Width / 2 - 160, Config.Height - 160)
    menuMatrix.draw(batch, Config.Width / 2 - 20, 480)
    batch.end()
  }

  override def dispose(): Unit = {
    batch.dispose()
    Assets.dispose()
  }
}
