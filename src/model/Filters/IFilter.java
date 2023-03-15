package model.Filters;

import model.IImage;

/**
 * Represents an interface for model.Filters.
 */

public interface IFilter {

  /**
   * This applies a filter to Image.
   * @param image is original image.
   * @return IImage is original image with filter applied.
   */
  public IImage apply(IImage image);
  
}
