package totoro.upong

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.graphics.Texture.TextureWrap
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator

/**
  * Assets singleton. All assets are contained inside of thematical sub-objects.
  * Tex - textures and images, Font - fonts.
  * Do not forget to dispose assets via `Assets.dispose()` call, at the end of work.
  */

object Assets {
  object Tex {
    val Background: Texture = new Texture(Gdx.files.internal("tex/menu-back.png"))
    Background.setWrap(TextureWrap.Repeat, TextureWrap.Repeat)
    val Kururi1: Texture = new Texture(Gdx.files.internal("tex/kururi-1.png"))
    val Kururi2: Texture = new Texture(Gdx.files.internal("tex/kururi-2.png"))
    val Logo: Texture = new Texture(Gdx.files.internal("tex/logo.png"))

    def dispose(): Unit = {
      Background.dispose()
      Kururi1.dispose()
      Kururi2.dispose()
      Logo.dispose()
    }
  }

  object Font {
    private val generator: FreeTypeFontGenerator =
      new FreeTypeFontGenerator(Gdx.files.internal("font/BelshawDonutRobot.ttf"))
    private val parameter = new FreeTypeFontGenerator.FreeTypeFontParameter
    parameter.size = 32
    parameter.color = Color.BLACK
    val Menu: BitmapFont = generator.generateFont(parameter)

    def dispose(): Unit = {
      generator.dispose()
    }
  }

  def dispose(): Unit = {
    Tex.dispose()
    Font.dispose()
  }
}
