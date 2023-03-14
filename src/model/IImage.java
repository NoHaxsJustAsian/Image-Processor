package model;

/**
 * Represents the interface for different types of Images.
 */
public interface IImage {

  /**
   * Retrieves the Pixels of the Image.
   * @return IPixel[][] pixels of the images.
   */
  public IPixel[][] getPixels();

  /**
   * Retrieves the Height of the Image.
   * @return int height of the image.
   */
  public int getHeight();

  /**
   * Retrieves the Width of the Image.
   * @return int width of the image.
   */
  public int getWidth();


}
