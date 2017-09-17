package totoro.upong

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.graphics.Texture.TextureWrap
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator

object Assets {
  object Tex {
    val MenuBackground: Texture = new Texture(Gdx.files.internal("tex/menu-back.png"))
    MenuBackground.setWrap(TextureWrap.Repeat, TextureWrap.Repeat)
    val Kururi1: Texture = new Texture(Gdx.files.internal("tex/kururi-1.png"))
    val Kururi2: Texture = new Texture(Gdx.files.internal("tex/kururi-2.png"))
    val Logo: Texture = new Texture(Gdx.files.internal("tex/logo.png"))

    def dispose(): Unit = {
      MenuBackground.dispose()
      Kururi1.dispose()
      Kururi2.dispose()
      Logo.dispose()
    }
  }

  object Font {
    private val generator: FreeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("font/BelshawDonutRobot.ttf"))
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
