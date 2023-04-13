package model.filters;

import java.util.List;

import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Darken Intensity filter.
 */
public class DarkenIntensity implements IFilter {

  private String name;

  /**
   * Constructs a Darken Intensity filter and sets its name.
   */
  public DarkenIntensity() {
    this.name = "darkenIntensity";
  }


  /**
   * Applies the darken intensity filter to the top layer.
   *
   * @param layers a list of layers.
   * @return IPixel[][] is the new image.
   */
  @Override
  public IPixel[][] apply(List<ILayer> layers, ILayer layer) {
    IPixel[][] pixels = layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color1 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3 - pixel.getRed();
        if (color1 < 0) {
          color1 = 0;
        }
        int color2 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3 - pixel.getGreen();
        if (color2 < 0) {
          color2 = 0;
        }
        int color3 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3 - pixel.getBlue();
        if (color3 < 0) {
          color3 = 0;
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



