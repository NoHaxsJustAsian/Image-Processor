package model.Filters;
import java.util.List;

import model.ILayer;
import model.IPixel;

/**
 * Represents an interface for model.Filters.
 */

public interface IFilter {

  /**
   * Applies the filter to the given layer.
   * @param layer is the layer to apply the filter to.
   * @param layers is the list of layers.
   * @return IPixel[][] is the new image.
   */
  public IPixel[][] apply(ILayer layer, List<ILayer> layers);


  /**
   * Gets the name of the filter.
   *
   * @return string name of the filter.
   */
  public String getName();
}

