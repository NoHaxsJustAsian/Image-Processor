package model;

/**
 * Represents an interface for HSL pixels.
 */
public interface IHSL {

/**
   * Returns the hue value of the pixel.
   *
   * @return the hue value of the pixel.
   */
  public double getHue();

  /**
   * Returns the saturation value of the pixel.
   *
   * @return the saturation value of the pixel.
   */
  public double getSaturation();

  /**
   * Returns the lightness value of the pixel.
   *
   * @return the lightness value of the pixel.
   */
  public double getLightness();
}
