package totoro.upong

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import upong.BuildInfo

/**
  * Entry point of the game.
  * Window configuration goes here.
  */

object UpongLauncher {
  def main(args: Array[String]): Unit = {
    val config: LwjglApplicationConfiguration = new LwjglApplicationConfiguration()
    config.width = Config.Width
    config.height = Config.Height
    config.title = s"Upong v${BuildInfo.version}"
    config.resizable = false
    new LwjglApplication(new Upong(), config)
  }
}
