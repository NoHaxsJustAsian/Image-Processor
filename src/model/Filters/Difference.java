package model.Filters;

import java.util.List;

import model.ILayer;
import model.IPixel;

public class Difference implements IFilter {

  String name;

  public Difference() {
    this.name = "difference";
  }


  @Override
  public IPixel[][] apply(ILayer layer, List<ILayer> layers) {
    return new IPixel[0][];
  }

  @Override
  public String getName() {
    return null;
  }
}
