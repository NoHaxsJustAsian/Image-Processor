package model.filters;

import java.util.List;

import model.ILayer;
import model.IPixel;

/**
 * Represents an interface for model.Filters.
 */
public interface IFilter {

  /**
   * Applies the filter to the given layer.
   * @param layers a list of layers.
   * @return IPixel[][] is the new image.
   */
  public IPixel[][] apply(List<ILayer> layers, ILayer layer);


  /**
   * Gets the name of the filter.
   *
   * @return string name of the filter.
   */
  public String getName();
}

