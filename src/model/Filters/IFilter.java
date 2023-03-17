package model.Filters;

import model.IImage;
import model.ILayer;
import model.IPixel;

/**
 * Represents an interface for model.Filters.
 */

public interface IFilter {

  /**
   * This applies a filter to Image.
   * @param layer is original image.
   * @return IPixel is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer);

  /**
   * Gets the name of the filter.
   * @return string name of the filter.
   */
  public String getName();
}


//when u apply, u are outputting a canvas, which then will replace a layer's canvas, and you
// will have to change that respective layers filter, to normal.