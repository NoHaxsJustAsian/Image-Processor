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
   * @return int
   */
  public int getHeight();

  /**
   *
   * @return
   */
  public int getWidth();


}
