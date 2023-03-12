package model;

/**
 * Represents a class for a pixel's values.
 */
public class Pixel {
  int red;
  int blue;
  int green;
  int alpha;

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


}
