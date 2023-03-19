package model;

/**
 * This class represents a PPM image.
 */
public class PPMImage extends AImage {

  /**
   * Represents a constructor for the PPM image.
   *
   * @param content 2D array of pixels.
   * @param height  int height.
   * @param width   int width.
   */
  public PPMImage(IPixel[][] content, int height, int width) {
    super(content, height, width);
  }


}
