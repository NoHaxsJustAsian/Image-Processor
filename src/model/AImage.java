package model;

/**
 * Represents an abstract class for Image types.
 */
public class AImage implements IImage {
  IPixel[][] content;
  int height;
  int width;

  /**
   * Represents a constructor for all Images.
   * @param content is all the pixels in an image.
   * @param height int height.
   * @param width int width.
   */
  public AImage(IPixel[][] content, int height, int width) {
    this.content = content;
    this.height = height;
    this.width = width;
  }

  /**
   * Retrieves the Pixels of the Image.
   * @return IPixel[][] pixels of the images.
   */
  @Override
  public IPixel[][] getPixels() {
    return content;
  }

  /**
   * Retrieves the Pixel at the given location.
   * @param x pos.
   * @param y pos.
   * @return IPixel at the given location.
   */
  public IPixel getPixel(int x, int y) { //FIXME: this needs throw exception
    return content[x][y];
  }

  /**
   * Retrieves the Height of the Image.
   * @return int height.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Retrieves the Width of the Image.
   * @return int width.
   */
  @Override
  public int getWidth() {
    return this.width;
  }
}
