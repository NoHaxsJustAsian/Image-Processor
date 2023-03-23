package model.Filters.HSL;

import model.Filters.IFilter;
import model.IImageProcessorModel;
import model.ILayer;
import model.IPixel;

public class Screen implements IFilterHSL {
  @Override
  public IPixel[][] apply(ILayer layer, IImageProcessorModel model) {
    return new IPixel[0][];
  }

  @Override
  public String getName() {
    return null;
  }
}
