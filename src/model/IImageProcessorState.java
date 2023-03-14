package model;

import Filters.IFilter;
import Filters.Normal;

public interface IImageProcessorState {

  public int getHeight();

  public int getWidth();

  public int getMaxValue();

  public ILayer getLayer(int num);



}
