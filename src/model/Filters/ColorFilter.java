package model.Filters;

import model.AImage;
import model.IImage;
import model.IPixel;
import model.Pixel;

/**
 * Represents a color filter.
 */
public class ColorFilter {
  private int color;

  public ColorFilter(IImage image) {
  }


  public IImage apply(IImage image, String color) {
    IPixel[][] pixels =  image.getPixels();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        switch (color) {
          case "red":
            int red = pixel.getRed();
            newPixels[i][j] = new Pixel(red, 0, 0, pixel.getAlpha());
            break;
          case "green":
            int green = pixel.getGreen();
            newPixels[i][j] = new Pixel(0, green, 0, pixel.getAlpha());
            break;
          case "blue":
            int blue = pixel.getBlue();
            newPixels[i][j] = new Pixel(0, 0, blue, pixel.getAlpha());
            break;
        }
      }
    }
    return new AImage(newPixels, image.getHeight(), image.getWidth());
  }
}
