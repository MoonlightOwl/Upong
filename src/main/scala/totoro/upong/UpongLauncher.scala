package totoro.upong

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}

object UpongLauncher {
  def main(args: Array[String]): Unit = {
    val config: LwjglApplicationConfiguration = new LwjglApplicationConfiguration()
    new LwjglApplication(new Upong(), config)
  }
}
