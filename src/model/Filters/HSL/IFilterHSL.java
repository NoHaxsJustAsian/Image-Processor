package model.Filters.HSL;

import model.IImageProcessorModel;
import model.ILayer;
import model.IPixel;

/**
 * Represents an interface for Filters, with access to the
 * model and other layers other than the one
 * it is being fed.
 */
public interface IFilterHSL {

  /**
   * This applies a filter to Image.
   *
   * @param layer is original image.
   * @return IPixel is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer, IImageProcessorModel model);

  /**
   * Gets the name of the filter.
   *
   * @return string name of the filter.
   */
  public String getName();
}
