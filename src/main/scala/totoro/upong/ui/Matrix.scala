package totoro.upong.ui

import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}

/**
  * Special widget for terminal emulation, and the like.
  * This is a characters matrix which can be rendered onto the screen.
  *
  * @param width the width of char matrix
  * @param height the height of char matrix
  * @param font the font that will be used to render the matrix
  */

class Matrix(width: Int, height: Int, font: BitmapFont) {
  private val buffer = new StringBuffer((width+1) * height)

  for (index <- 0 until buffer.capacity()) buffer.append(if (index % (width+1) == width) '\n' else ' ')

  def set(x: Int, y: Int, char: Char): Unit = {
    buffer.setCharAt(y * (width + 1) + x, char)
  }

  def get(x: Int, y: Int): Char = buffer.charAt(y * (width + 1) + x)

  def draw(batch: SpriteBatch, x: Int, y: Int): Unit = {
    font.draw(batch, buffer, x, y)
  }
}
