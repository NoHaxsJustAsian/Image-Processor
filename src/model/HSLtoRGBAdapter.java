package model;

/**
 * Represents an adapter for HSL pixels.
 */
public class HSLtoRGBAdapter extends HSL implements IPixel {


  /**
   * Represents constructor for HSLtoRBGAdapter.
   *
   * @param hue        pixel value.
   * @param saturation pixel value.
   * @param lightness  pixel value.
   * @throws IllegalArgumentException if any of the values are out of range.
   */
  public HSLtoRGBAdapter(double hue, double saturation,
                         double lightness) throws IllegalArgumentException {
    super(hue, saturation, lightness);
  }

  /**
   * Returns the red value of the pixel.
   *
   * @return the red value of the pixel.
   */
  @Override
  public int getRed() {
    return (int) (convertFn(getHue(), getSaturation(), getLightness(), 0) * 255);
  }

  /**
   * Returns the blue value of the pixel.
   *
   * @return the blue value of the pixel.
   */
  @Override
  public int getBlue() {
    return (int) (convertFn(getHue(), getSaturation(), getLightness(), 4) * 255);
  }

  /**
   * Returns the green value of the pixel.
   *
   * @return the green value of the pixel.
   */
  @Override
  public int getGreen() {
    return (int) (convertFn(getHue(), getSaturation(), getLightness(), 8) * 255);
  }

  /**
   * Returns the alpha value of the pixel.
   *
   * @return the alpha value of the pixel.
   */
  @Override
  public int getAlpha() {
    return 255;
  }

  /*
   * Helper method that performs the translation from the HSL polygonal
   * model to the more familiar RGB model
   */
  private static double convertFn(double hue, double saturation, double lightness, int n) {
    double k = (n + (hue / 30)) % 12;
    double a = saturation * Math.min(lightness, 1 - lightness);
    return lightness - a * Math.max(-1, Math.min(k - 3, Math.min(9 - k, 1)));
  }
}
