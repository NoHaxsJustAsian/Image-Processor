package model.Filters;

import model.ILayer;
import model.IPixel;

public class Multiply implements IFilter {
  @Override
  public IPixel[][] apply(ILayer layer) {
    return new IPixel[0][];
  }


  @Override
  public String getName() {
    return null;
  }
}
