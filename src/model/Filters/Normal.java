package model.Filters;

import model.IImage;
import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents a filter with no effect. This is the default filter.
 */
public class Normal implements IFilter {

  /**
   * This applies no filter to Image.
   * @param layer is original image.
   * @return IImage is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer) {
    return layer.getCanvas();
  }
}
