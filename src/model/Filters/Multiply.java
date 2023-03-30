package model.Filters;

import java.util.List;

import model.ILayer;
import model.IPixel;

public class Multiply implements IFilter {

  String name;

  public Multiply() {
    this.name = "multiply";
  }

  /**
   * Applies the filter to the given layer.
   * @param layers a list of layers.
   * @return IPixel[][] is the new image.
   */
  @Override
  public IPixel[][] apply(List<ILayer> layers, ILayer layer) {
    IPixel[][] pixels1 = layer.getCanvas();
    IPixel[][] pixels2;

    for(int i = layers.indexOf(layer) + 1; i < layers.size() - 1; i++) {
      IPixel[][] finalPixels = new IPixel[layer.getHeight()][layer.getWidth()];
        ILayer layerCurrent = layers.get(i);
        layerCurrent.setCanvas(layerCurrent.getFilter().apply(layers, layerCurrent));
        for (int j = 0; j < layer.getHeight(); j++) {
          for (int k = 0; k < layer.getWidth(); k++) {
            finalPixels[i][j] = layers.get(i).getPixel(j, k);
          }
        }
      pixels2 = finalPixels;
    }

    for(int i = 0; i < layer.getHeight(); i++) {
      for(int j = 0; j < layer.getWidth(); j++) {
        IPixel pixelTop = pixels1[i][j];


      }
    }



    IPixel[][] newPixels = new IPixel[pixels1.length][pixels1[0].length];

    if (pixels1.length != pixels2.length || pixels1[0].length != pixels2[0].length) {
      throw new IllegalArgumentException("Images must be the same size");
    }

    for (int i = 0; i < layer.getHeight(); i++) {
      for (int j = 0; j < layer.getWidth(); j++) {



      }
    }
  }

  @Override
  public String getName() {
    return "multiply";
  }
}
