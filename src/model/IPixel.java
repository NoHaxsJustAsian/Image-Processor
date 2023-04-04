package model;


/**
 * Represents a pixel. Allows clients to observes red, green, blue, and alpha values of a pixel.
 */
public interface IPixel {

  /**
   * Returns the red value of the pixel.
   * 0 to 255.
   * @return the red value of the pixel.
   */
  public int getRed();

  /**
   * Returns the green value of the pixel.
   * 0 to 255.
   * @return the green value of the pixel.
   */
  public int getGreen();

  /**
   * Returns the blue value of the pixel.
   * 0 to 255.
   * @return the blue value of the pixel.
   */
  public int getBlue();

  /**
   * Returns the alpha value of the pixel.
   * 0 to 255.
   * @return the alpha value of the pixel.
   */
  public int getAlpha();

}
