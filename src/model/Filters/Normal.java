package model.Filters;


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
   * This applies no filter to Image.
   *
   * @param layer is original image.
   * @return IImage is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer) {
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
