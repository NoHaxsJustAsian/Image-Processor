package Filters;

import java.awt.*;

import model.AImage;
import model.IImage;
import model.IPixel;

import model.PPMImage;
import model.Pixel;

/**
 * Represents a red filter.
 */
public class RedFilter implements IFilter {
  int red;

  /**
   * Represents constructor for RedFilter.
   * @param red is the int value of the red component.
   */
  public RedFilter(int red) {
    this.red = red;
  }

  /**
   * This applies red filter to Image.
   * @param image is original image.
   * @return IImage is original image with filter applied.
   */
  public IImage apply(IImage image) {
    IPixel[][] pixels =  image.getPixels();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color = pixel.getRed();
        newPixels[i][j] = new Pixel(color, 0, 0, pixel.getAlpha());
      }
    }
    return new AImage(newPixels, image.getHeight(), image.getWidth());
  }


}
