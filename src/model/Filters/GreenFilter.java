package model.Filters;

import java.util.List;

import model.ILayer;
import model.IPixel;

import model.Pixel;

/**
 * Represents a green filter.
 */
public class GreenFilter implements IFilter {
  String name;

  public GreenFilter() {
    this.name = "greenFilter";
  }

  /**
   * This applies green filter to Image.
   *
   * @param layer is original image.
   * @return IImage is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer, List<ILayer> layers) {
    IPixel[][] pixels = layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color = pixel.getGreen();
        newPixels[i][j] = new Pixel(0, color, 0, pixel.getAlpha());
      }
    }
    return newPixels;
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
