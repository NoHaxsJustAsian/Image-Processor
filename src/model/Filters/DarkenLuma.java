package model.Filters;


import model.ILayer;
import model.IPixel;
import model.Pixel;

/**
 * Represents the Darken Luma filter.
 */
public class DarkenLuma implements IFilter {

  String name;

  public DarkenLuma() {
    this.name = "darkenLuma";
  }

  @Override
  public IPixel[][] apply(ILayer layer) {
    IPixel[][] pixels = layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color1 = pixel.getRed() - ((pixel.getRed() / (pixel.getRed() + pixel.getGreen() + pixel.getBlue())) * pixel.getRed());
        int color2 = pixel.getGreen() - ((pixel.getGreen() / (pixel.getRed() + pixel.getGreen() + pixel.getBlue())) * pixel.getGreen());
        int color3 = pixel.getBlue() - ((pixel.getBlue() / (pixel.getRed() + pixel.getGreen() + pixel.getBlue())) * pixel.getBlue());
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



