package totoro.upong

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import upong.BuildInfo

object UpongLauncher {
  def main(args: Array[String]): Unit = {
    val config: LwjglApplicationConfiguration = new LwjglApplicationConfiguration()
    config.width = Config.Width
    config.height = Config.Height
    config.title = s"Upong v${BuildInfo.version}"
    new LwjglApplication(new Upong(), config)
  }
}
