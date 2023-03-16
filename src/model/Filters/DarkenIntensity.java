package model.Filters;

import model.AImage;
import model.IImage;
import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Darken Intensity filter.
 */
public class DarkenIntensity implements IFilter {

  int red;
  int green;
  int blue;

  public DarkenIntensity(int red, int green, int blue) {
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
        int color1 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3 - pixel.getRed();
        int color2 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3 - pixel.getGreen();
        int color3 = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3 - pixel.getBlue();
        newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
      }
    }
    return newPixels;
  }
}



