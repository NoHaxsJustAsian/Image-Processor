package model;

/**
 * Represents an abstract class for Image types.
 */
public class AImage implements IImage {

  Pixel[][] content;
  int height;
  int width;

  AImage(Pixel[][] content, int height,  int width) {
    this.content = content;
    this.height = height;
    this.width = width;
  }

  @Override
  public IPixel[][] getPixels() {
    return new IPixel[0][];
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }
}
