package model.Filters;

import model.AImage;
import model.IImage;
import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Darken Luma filter.
 */
public class DarkenLuma implements IFilter {

  int red;
  int green;
  int blue;

  public DarkenLuma(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public IPixel[][] apply(ILayer layer) {
    IPixel[][] pixels = layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color1 = ((pixel.getRed()/100) * pixel.getRed()) - pixel.getRed();
        int color2 = ((pixel.getGreen()/100) * pixel.getGreen()) - pixel.getGreen();
        int color3 =  ((pixel.getBlue()/100) * pixel.getBlue()) - pixel.getBlue();
        newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
      }
    }
    return newPixels;
  }

  /**
   * Gets the name of the filter.
   * @return string name of the filter.
   */
  public String getName() {
    return "darken luma";
  }
}



