package model.Filters;

import java.util.List;
import java.util.Map;

import model.ILayer;
import model.IPixel;
import model.Pixel;

public class Difference implements IFilter {

  String name;

  public Difference() {
    this.name = "difference";
  }


  /**
   * Applies the difference filter to the top layer based on bottom image.
   * @param layers a list of layers.
   * @return IPixel[][] is the new image.
   */
  @Override
  public IPixel[][] apply(List<ILayer> layers, ILayer layer) {
    ILayer layer2;
    try {
      layer2 = layers.get(layers.indexOf(layer) + 1);
    }
    catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("No bottom layer");
    }


    IPixel[][] pixels1 = layer.getCanvas();
    IPixel[][] pixels2 = layer2.getCanvas();

    IPixel[][] newPixels = new IPixel[pixels1.length][pixels1[0].length];

    if (pixels1.length != pixels2.length || pixels1[0].length != pixels2[0].length) {
      throw new IllegalArgumentException("Images must be the same size");
    }

    for (int i = 0; i < pixels1.length; i++) {
      for (int j = 0; j < pixels1[0].length; j++) {
        IPixel pixel1 = pixels1[i][j];
        int r = pixel1.getRed();
        int g = pixel1.getGreen();
        int b = pixel1.getBlue();
        for (int k = 0; k < pixels2.length; k++) {
          for (int l = 0; l < pixels2[0].length; l++) {
            IPixel pixel2 = pixels2[i][j];
            int dr = pixel2.getRed();
            int dg = pixel2.getGreen();
            int db = pixel2.getBlue();

            int rr = Math.abs(r - dr);
            int gg = Math.abs(g - dg);
            int bb = Math.abs(b - db);

            newPixels[i][j] = new Pixel(rr, gg, bb, pixel1.getAlpha());
          }
        }

      }
    }
    return newPixels;
  }

  @Override
  public String getName() {
    return null;
  }
}
