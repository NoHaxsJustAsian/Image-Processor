package model.Filters;


import java.util.List;

import model.ILayer;
import model.IPixel;


/**
 * Represents a filter with no effect. This is the default filter.
 */
public class Normal implements IFilter {
  String name;

  public Normal() {
    this.name = "normal";
  }

  /**
   * This applies no filter to the top Layer.
   * @param layers is original image.
   * @return IImage is original image with filter applied.
   */
  public IPixel[][] apply(List<ILayer> layers, ILayer layer) {
    return layer.getCanvas();
  }

  /**
   * Gets the name of the filter.
   *
   * @return string name of the filter.
   */
  public String getName() {
    return this.name;
  }
}
