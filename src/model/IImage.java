package model;

/**
 * Represents the interface for different types of Images.
 */
public interface IImage {

  /**
   * Retrieves the Pixels of the Image.
   *
   * @return IPixel[][] pixels of the images.
   */
  IPixel[][] getPixels();

  /**
   * Retrieves the Pixel at the given location.
   *
   * @param x pos.
   * @param y pos.
   * @return IPixel at the given location.
   */
  IPixel getPixel(int x, int y);

  /**
   * Retrieves the Height of the Image.
   *
   * @return int height.
   */
  int getHeight();

  /**
   * Retrieves the Width of the Image.
   *
   * @return int width.
   */
  int getWidth();


}
