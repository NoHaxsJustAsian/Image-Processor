package model;

import Filters.IFilter;

/**
 * Interface for a Layer.
 */
public interface ILayer {

  /**
   * Sets the filter for the layer.
   * @param filter to be set.
   */
  public void setFilter(IFilter filter);

  /**
   * Adds an image to the layer.
   * @param x offset
   * @param y offset
   * @param image to be added.
   */
  public void addImage(int x, int y, IImage image);

  /**
   * returns the canvas from the layer.
   */
  public Layer getCanvas();



}
