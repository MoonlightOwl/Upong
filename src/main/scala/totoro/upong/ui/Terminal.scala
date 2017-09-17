package totoro.upong.ui

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

  def update(): Unit = {
    if (System.currentTimeMillis() % 1000 < 500) {
      if (cursorVisible) { matrix.set(cursorX, cursorY, '_'); cursorVisible = false }
    } else {
      if (!cursorVisible) { matrix.set(cursorX, cursorY, ' '); cursorVisible = true }
    }
  }

  def setCursor(x: Int, y: Int): Boolean = {
    if (x >= 0 && x < width && y >= 0 && y < height) {
      cursorX = x; cursorY = y
      true
    } else false
  }

  def getCursor: (Int, Int) = (cursorX, cursorY)

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
  }

  def draw(batch: SpriteBatch, x: Int, y: Int): Unit = {
    matrix.draw(batch, x, y)
  }
}
