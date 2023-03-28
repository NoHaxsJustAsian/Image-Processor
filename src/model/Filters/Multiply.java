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


    for(int i = layers.indexOf(layer); i < layers.size(); i++) {

    }


    for (int x = 0; x < layers.size(); x++) {
      ILayer layer = layers.get(x);
      layer.setCanvas(layer.getFilter().apply(layers, layer));
      for (int i = 0; i < getHeight(); i++) {
        for (int j = 0; j < getWidth(); j++) {
          finalPixels[i][j] = orderLayers.get(x).getPixel(i, j);
        }
      }
    }

    ILayer layer2;

    try {
      layer2 = layers.get(layers.indexOf(layer) + 1);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("No bottom layer");
    }


    IPixel[][] pixels1 = layer.getCanvas();
    IPixel[][] pixels2 = layer2.getCanvas();

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
