package Filters;

import model.IImage;

/**
 * Represents a filter with no effect. This is the default filter.
 */
public class Normal implements IFilter {

  /**
   * This applies green filter to Image.
   * @param image is original image.
   * @return IImage is original image with filter applied.
   */
  public IImage apply(IImage image) {
    return image;
  }
}
