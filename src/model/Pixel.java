package model;

/**
 * Represents a class for a pixel's component values as integers.
 *
 */
public class Pixel implements IPixel {
  private int red;
  private int green;
  private int blue;
  private int alpha;

  /**
   * Represents constructor for Pixel.
   *
   * @param red   pixel value.
   * @param green pixel value.
   * @param blue  pixel value.
   * @param alpha value.
   * @throws IllegalArgumentException if any of the values are out of range.
   */
  public Pixel(int red, int green, int blue, int alpha) throws IllegalArgumentException {
    if (red > 255 || red < 0) {
      throw new IllegalArgumentException("Red value is out of range");
    }
    if (green > 255 || green < 0) {
      throw new IllegalArgumentException("Green value is out of range");
    }
    if (blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Blue value is out of range");
    }
    if (alpha > 255 || alpha < 0) {
      throw new IllegalArgumentException("Alpha value is out of range");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }


  /**
   * Returns the red value of the pixel.
   *
   * @return the red value of the pixel.
   */
  @Override
  public int getRed() {
    return this.red;
  }


  /**
   * Returns the green value of the pixel.
   *
   * @return the green value of the pixel.
   */
  @Override
  public int getGreen() {
    return this.green;
  }

  /**
   * Returns the blue value of the pixel.
   *
   * @return the blue value of the pixel.
   */
  @Override
  public int getBlue() {
    return this.blue;
  }

  /**
   * Returns the alpha value of the pixel.
   *
   * @return the alpha value of the pixel.
   */
  @Override
  public int getAlpha() {
    return this.alpha;
  }
}
