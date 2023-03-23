package model.Filters;
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
   *
   * @return string name of the filter.
   */
  public String getName();
}

