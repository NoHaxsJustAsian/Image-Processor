package model.Filters;

import model.ILayer;
import model.IPixel;

public class Screen implements IFilter{
  @Override
  public IPixel[][] apply(ILayer layer) {
    return new IPixel[0][];
  }

  @Override
  public String getName() {
    return null;
  }
}
