package totoro.upong.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Interpolation
import totoro.upong.ui.Terminal
import totoro.upong.{Assets, Config, Upong}

/**
  * This class is responsible for main menu processing.
  * @param game the parent game object
  */

class MainMenuScreen(game: Upong) extends GameScreen {
  private val terminal: Terminal = new Terminal(19, 14, Assets.Font.Menu)

  private var step: Int = AnimationStep.In
  private val interpolation: Interpolation = Interpolation.pow4
  private var elapsed = 0f
  private val total = 0.5f
  private var progress = 0f

  terminal.println("Ohayou!")
  terminal.println("This is Upong, mul-tiplayer ping-pong game. Welcome and  enjoy!")
  terminal.println()
  terminal.print("> ")

  terminal.setCommandsProcessor(command => {
    terminal.println()
    command match {
      case "exit" => Gdx.app.exit()
      case "" =>
      case _ => terminal.println("command not found")
    }
    terminal.print("> ")
  })

  override def keyTyped(character: Char): Boolean = {
    terminal.keyTyped(character)
  }

  override def keyDown(keycode: Int): Boolean = {
    terminal.keyDown(keycode)
  }

  override def render(delta: Float): Unit = {
    if (step == AnimationStep.In && elapsed < total) {
      elapsed += delta
      progress = interpolation.apply(elapsed / total)
    } else {
      step = AnimationStep.Steady
      progress = 1
    }

    terminal.update()

    game.batch.begin()
    game.batch.draw(Assets.Tex.Background, 0, 0, 0, 0, Config.Width, Config.Height)
    game.batch.draw(Assets.Tex.Logo, Config.Width / 2 - 160, Config.Height - 160 * progress)
    game.batch.draw(Assets.Tex.Kururi1, 20, (progress - 1) * 100)
    terminal.draw(game.batch, Config.Width / 2 - 20, 440 + (40 * progress).toInt)
    game.batch.end()
  }
}
