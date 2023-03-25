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
    return new IPixel[0][];
  }

  @Override
  public String getName() {
    return null;
  }
}
