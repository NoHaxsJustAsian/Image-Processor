package model;

/**
 * Represents a class for a pixel's values in HSL.
 */
public class HSL implements IHSL {
  private double hue;
  private double saturation;
  private double lightness;

  /**
   * Represents constructor for Pixel.
   *
   * @param hue        pixel value
   * @param saturation pixel value
   * @param lightness  pixel value
   * @throws IllegalArgumentException if any of the values are out of range.
   */
  public HSL(double hue, double saturation, double lightness) throws IllegalArgumentException {
    if (hue > 360 || hue < 0) {
      throw new IllegalArgumentException("Hue value is out of range");
    }
    if (saturation > 1 || saturation < 0) {
      throw new IllegalArgumentException("Saturation value is out of range");
    }
    if (lightness > 255 || lightness < 0) {
      throw new IllegalArgumentException("Lightness value is out of range");
    }
    this.hue = hue;
    this.saturation = saturation;
    this.lightness = lightness;
  }

  /**
   * Returns the hue value of the pixel.
   *
   * @return hue
   */
  public double getHue() {
    return this.hue;
  }

  /**
   * Returns the saturation value of the pixel.
   *
   * @return saturation
   */
  public double getSaturation() {
    return this.saturation;
  }

  /**
   * Returns the lightness value of the pixel.
   *
   * @return lightness
   */
  public double getLightness() {
    return this.lightness;
  }
}