package model.filters;

import java.util.List;

import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Brighten Luma filter.
 */
public class BrightenLuma implements IFilter {

  String name;

  public BrightenLuma() {
    this.name = "brightenLuma";
  }

  /**
   * Applies the brighten luma filter to the top layer.
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
        int color1 = pixel.getRed() + (((pixel.getRed() / (pixel.getRed() + pixel.getGreen()
                + pixel.getBlue())) * pixel.getRed()));
        if (color1 > 255) {
          color1 = 255;
        }
        int color2 = pixel.getGreen() + ((pixel.getGreen() / (pixel.getRed() + pixel.getGreen()
                + pixel.getBlue())) * pixel.getGreen());
        if (color2 > 255) {
          color2 = 255;
        }
        int color3 = pixel.getBlue() + ((pixel.getBlue() / (pixel.getRed() + pixel.getGreen()
                + pixel.getBlue()) * pixel.getBlue()));
        if (color3 > 255) {
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



