package model.Filters;

import model.ILayer;
import model.IPixel;
import model.Pixel;

public class Difference implements IFilter {

  String name;

  public Difference() {
    this.name = "difference";
  }


  @Override
  public IPixel[][] apply(ILayer layer) {
    IPixel[][] pixels = layer.getCanvas();
    
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];

        int color1 = Math.abs(pixel.getRed() - pixel.getRed());
        if(color1 < 0) {
          color1 = 0;
        }


        newPixels[i][j] = new Pixel(color1, color2, color3, pixel.getAlpha());
      }
    }
    return newPixels;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
