package Filters;

import model.IImage;

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
