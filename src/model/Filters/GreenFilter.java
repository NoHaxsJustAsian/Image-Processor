package model.Filters;

import model.AImage;
import model.IImage;
import model.ILayer;
import model.IPixel;

import model.Pixel;

/**
 * Represents a green filter.
 */
public class GreenFilter implements IFilter {
  int green;

  /**
   * Represents constructor for GreenFilter.
   * @param green is the int value of the green component.
   */
  public GreenFilter(int green) {
    this.green = green;
  }

  /**
   * This applies green filter to Image.
   * @param layer is original image.
   * @return IImage is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer) {
    IPixel[][] pixels =  layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color = pixel.getGreen();
        newPixels[i][j] = new Pixel(0, 0, color, pixel.getAlpha());
      }
    }
    return newPixels;
  }
}
