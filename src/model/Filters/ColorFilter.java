package model.Filters;


import model.IImage;
import model.IPixel;
import model.Pixel;
import model.ILayer;

/**
 * Represents a color filter.
 */
public class ColorFilter {
  private int color;

  public ColorFilter(IImage image) {
  }

  /**
   * Applies the color filter to the layer.
   * @param layer a layer.
   * @param color a string representing the color.
   * @return IPixel[][] is the new image.
   */
  public IPixel[][] apply(ILayer layer, String color) {
    IPixel[][] pixels = layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
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
    return newPixels;
  }
}
