package Filters;

import model.IImage;

/**
 * Represents a filter with no effect. This is the default filter.
 */
public class Normal implements IFilter {

  /**
   *
   * @param image
   * @return
   */
  public IImage apply(IImage image) {
    return image;
  }
}
