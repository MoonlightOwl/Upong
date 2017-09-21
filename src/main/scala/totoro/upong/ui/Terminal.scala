package totoro.upong.ui

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}

/**
  * Special widget that can simulate terminal-like behavior.
  * It can listen to user input, and print some information back.
  * @param width the terminal matrix width (in chars)
  * @param height the terminal matrix height (in chars)
  * @param font the font that will be used to render the terminal
  */

class Terminal(width: Int, height: Int, font: BitmapFont) {
  private val matrix: Matrix = new Matrix(width, height, font)
  private var cursorX: Int = 0
  private var cursorY: Int = 0
  private var cursorVisible: Boolean = false
  private var input: String = ""
  private var commandProcessor: String => Unit = _

  private def inBounds(x: Int, y: Int): Boolean = x >= 0 && x < width && y >= 0 && y < height
  private def endOfPhrase(y: Int): Option[Int] = {
    if (inBounds(0, y))
      for (x <- (width - 1) to 0 by -1) {
        if (!matrix.get(x, y).isWhitespace) return Some(x)
      }
    None
  }

  // Cursor management & output features
  def setCursor(x: Int, y: Int): Boolean = {
    if (inBounds(x, y)) {
      cursorX = x; cursorY = y
      true
    } else false
  }
  def getCursor: (Int, Int) = (cursorX, cursorY)

  def rewind(): Unit = {
    if (!setCursor(0, cursorY + 1)) {
      shift()
      setCursor(0, cursorY)
    }
  }
  def shift(): Unit = {
    for (y <- 0 until (height - 1))
      for (x <- 0 until width)
        matrix.set(x, y, matrix.get(x, y+1))
    for (x <- 0 until width) matrix.set(x, height-1, ' ')
  }
  def backspace(): Unit = {
    if (!setCursor(cursorX - 1, cursorY))
      if (!setCursor(endOfPhrase(cursorY - 1).getOrElse(0), cursorY - 1))
        setCursor(0, 0)
    delete()
  }
  def delete(): Unit = {
    matrix.set(cursorX, cursorY, ' ')
  }

  def println(): Unit = print("\n")
  def println(str: String): Unit = print(str + '\n')
  def print(str: String): Unit = str.foreach(put)
  def put(char: Char): Unit = {
    if (char == '\n') rewind()
    else {
      matrix.set(cursorX, cursorY, char)
      if (!setCursor(cursorX + 1, cursorY)) rewind()
    }
  }


  // Commands processing
  def setCommandsProcessor(processor: String => Unit): Unit = commandProcessor = processor


  // Input features
  def keyTyped(character: Char): Boolean = {
    if (!character.isControl) {
      input += character
      put(character)
      true
    } else false
  }
  def keyDown(keycode: Int): Boolean = {
    keycode match {
      case Keys.BACKSPACE =>
        if (input.length > 0) {
          input = input.dropRight(1)
          delete()
          backspace()
          true
        } else false
      case Keys.ENTER =>
        if (commandProcessor != null) commandProcessor(input)
        input = ""
        true
      case _ => false
    }
  }

  def getInput: String = input


  // Lifecycle methods
  def update(): Unit = {
    if (System.currentTimeMillis() % 1000 < 500) {
      if (cursorVisible) { matrix.set(cursorX, cursorY, '_'); cursorVisible = false }
    } else {
      if (!cursorVisible) { matrix.set(cursorX, cursorY, ' '); cursorVisible = true }
    }
  }
  def draw(batch: SpriteBatch, x: Int, y: Int): Unit = {
    matrix.draw(batch, x, y)
  }
}
