package model.Filters;

import java.util.List;

import model.ILayer;
import model.IPixel;

public class Multiply implements IFilter {


  @Override
  public IPixel[][] apply(ILayer layer, List<ILayer> layers) {
    return new IPixel[0][];
  }

  @Override
  public String getName() {
    return null;
  }
}
