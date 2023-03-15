package model.Filters;

import model.AImage;
import model.IImage;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Brighten Value filter.
 */
public class BrightenValue implements IFilter {

  int red;
  int green;
  int blue;

  public BrightenValue(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public IImage apply(IImage image) {
    IPixel[][] pixels = image.getPixels();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        if(pixel.getRed() > pixel.getGreen() && pixel.getRed() > pixel.getBlue()) {
          int color1 = pixel.getRed() + pixel.getRed();
          int color2 = pixel.getGreen() + pixel.getRed();
          int color3 = pixel.getBlue() + pixel.getRed();
          newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
        } else if(pixel.getGreen() > pixel.getRed() && pixel.getGreen() > pixel.getBlue()) {
          int color1 = pixel.getRed() + pixel.getGreen();
          int color2 = pixel.getGreen() + pixel.getGreen();
          int color3 = pixel.getBlue() + pixel.getGreen();
          newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
        } else {
          int color1 = pixel.getRed() + pixel.getBlue();
          int color2 = pixel.getGreen() + pixel.getBlue();
          int color3 = pixel.getBlue() + pixel.getBlue();
          newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
        }
      }
    }
    return new AImage(newPixels, image.getHeight(), image.getWidth());
  }
}



