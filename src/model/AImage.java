package model;

/**
 * Represents an abstract class for Image types.
 */
public abstract class AImage implements IImage {
  IPixel[][] content;
  private int height;
  private int width;

  /**
   * Represents a constructor for all Images.
   *
   * @param content is all the pixels in an image.
   * @param height  int height.
   * @param width   int width.
   */
  public AImage(IPixel[][] content, int height, int width) throws IllegalArgumentException {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("Image dimensions must be positive");
    }
    this.content = content;
    this.height = height;
    this.width = width;
  }

  /**
   * Retrieves the Pixels of the Image.
   *
   * @return IPixel[][] pixels of the images.
   */
  @Override
  public IPixel[][] getPixels() {
    return content;
  }

  /**
   * Retrieves the Pixel at the given location.
   *
   * @param x pos.
   * @param y pos.
   * @return IPixel at the given location.
   */
  public IPixel getPixel(int x, int y) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Image dimensions must be positive");
    }
    if (x >= this.height || y >= this.width) {
      throw new IllegalArgumentException("Image dimensions must be within bounds");
    }
    return content[x][y];
  }

  /**
   * Retrieves the Height of the Image.
   *
   * @return int height.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Retrieves the Width of the Image.
   *
   * @return int width.
   */
  @Override
  public int getWidth() {
    return this.width;
  }
}
