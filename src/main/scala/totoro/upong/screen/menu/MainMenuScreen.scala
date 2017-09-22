package totoro.upong.screen.menu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Interpolation
import totoro.upong.screen.GameScreen
import totoro.upong.screen.gameplay.PingPongScreen
import totoro.upong.ui.{AnimationStep, Terminal}
import totoro.upong.{Assets, Config, Upong}

/**
  * This class is responsible for main menu processing.
  * @param game the parent game object
  */

class MainMenuScreen(game: Upong) extends GameScreen {
  private val terminal: Terminal = new Terminal(19, 14, Assets.Font.Menu)

  private var step: Int = AnimationStep.In
  private val interpolation: Interpolation = Interpolation.pow4
  private var elapsed: Float = 0f
  private val total: Float = 0.5f
  private var progress: Float = 0f
  private var callback: () => Unit = _

  terminal.println("Ohayou!")
  terminal.println("This is Upong, mul-tiplayer ping-pong game. Welcome and  enjoy!")
  terminal.println()
  terminal.print("> ")

  terminal.setCommandsProcessor(command => {
    terminal.println()
    command.toLowerCase match {
      case "help" | "h" | "man" | "?" | "wtf" =>
        terminal.print("available commands:")
        terminal.println("exit - leave this")
        terminal.println("       game")
      case "single" =>
        hide { () => game.setGameScreen(new PingPongScreen(game)) }
      case "exit" | "quit" | "q" => Gdx.app.exit()
      case "" =>
      case _ => terminal.println("command not found")
    }
    terminal.print("> ")
  })

  def hide(callback: () => Unit): Unit = {
    this.callback = callback
    step = AnimationStep.Out
    elapsed = 0
  }

  override def keyTyped(character: Char): Boolean = {
    terminal.keyTyped(character)
  }

  override def keyDown(keycode: Int): Boolean = {
    terminal.keyDown(keycode)
  }

  override def render(delta: Float): Unit = {
    step match {
      case AnimationStep.In =>
        if (elapsed < total) {
          elapsed += delta
          progress = interpolation.apply(elapsed / total)
        } else {
          step = AnimationStep.Steady
          progress = 1
        }
      case AnimationStep.Out =>
        if (elapsed < total) {
          elapsed += delta
          progress = 1 - interpolation.apply(elapsed / total)
        } else {
          step = AnimationStep.Hidden
          progress = 0
          callback()
        }
      case _ =>
    }

    terminal.update(delta)

    game.batch.begin()
    game.batch.draw(Assets.Tex.Background, 0, 0, 0, 0, Config.Width, Config.Height)
    game.batch.draw(Assets.Tex.Logo, Config.Width / 2 - 160, Config.Height - 160 * progress)
    game.batch.draw(Assets.Tex.Kururi1, 20, (progress - 1) * 520)
    terminal.draw(game.batch, Config.Width / 2 - 20, (480 * progress).toInt)
    game.batch.end()
  }
}
