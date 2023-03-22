package model.Filters;

import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Darken Intensity filter.
 */
public class DarkenIntensity implements IFilter {

  String name;

  public DarkenIntensity() {
    this.name = "darkenIntensity";
  }


  @Override
  public IPixel[][] apply(ILayer layer) {
    IPixel[][] pixels = layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color1 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3 - pixel.getRed();
        if(color1 > 255) {
          color1 = 255;
        }
        int color2 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3 - pixel.getGreen();
        if(color2 > 255) {
          color2 = 255;
        }
        int color3 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3 - pixel.getBlue();
        if(color3 > 255) {
          color3 = 255;
        }
        newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
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



