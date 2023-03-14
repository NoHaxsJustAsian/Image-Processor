package model;

/**
 * Represents a class for a pixel's values.
 */
public class Pixel implements IPixel {
  int red;
  int blue;
  int green;
  int alpha;

  /**
   * Represents constructor for Pixel.
   * @param red pixel value
   * @param blue pixel value
   * @param green pixel value
   * @param alpha value
   * @throws IllegalArgumentException
   */
  public Pixel(int red, int blue, int green, int alpha) throws IllegalArgumentException {
    if (red > 255 || red < 0) {
      throw new IllegalArgumentException("Red value is out of range");
    }
    if (blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Blue value is out of range");
    }
    if (green > 255 || green < 0) {
      throw new IllegalArgumentException("Green value is out of range");
    }
    if (alpha > 255 || alpha < 0) {
      throw new IllegalArgumentException("Alpha value is out of range");
    }
    this.red = red;
    this.blue = blue;
    this.green = green;
    this.alpha = alpha;
  }


  /**
   * Returns the red value of the pixel.
   * @return the red value of the pixel.
   */
  @Override
  public int getRed() {
    return this.red;
  }

  /**
   * Returns the blue value of the pixel.
   * @return the blue value of the pixel.
   */
  @Override
  public int getBlue() {
    return this.blue;
  }

  /**
   * Returns the green value of the pixel.
   * @return the green value of the pixel.
   */
  @Override
  public int getGreen() {
    return this.green;
  }

  /**
   * Returns the alpha value of the pixel.
   * @return the alpha value of the pixel.
   */
  @Override
  public int getAlpha() {
    return this.alpha;
  }
}
