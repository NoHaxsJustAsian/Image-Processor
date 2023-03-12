package Filters;

import model.IImage;

public interface IFilter {

  public IImage apply(IImage image);
  
}
