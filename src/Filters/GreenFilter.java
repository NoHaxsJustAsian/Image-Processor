package Filters;

import java.awt.*;

import model.IImage;
import model.IPixel;
import model.Pixel;

/**
 * Represents a green filter.
 */
public class GreenFilter implements IFilter {
  int green;

  /**
   * Represents constructor for GreenFIlter.
   * @param green
   */
  public GreenFilter(int green) {
    this.green = green;
  }

  /**
   * This applies the green filter to Image.
   * @param image
   * @return
   */
  public IImage apply(IImage image) {
    IPixel[][] pixels =  image.getPixels();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color = pixel.getGreen();
        newPixels[i][j] = new Pixel(0, 0, color, pixel.getAlpha());
      }
    }
    return new Image(newPixels, image.getHeight, image.getWidth);
  }
}
