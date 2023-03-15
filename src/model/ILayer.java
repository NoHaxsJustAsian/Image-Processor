package model;

import model.Filters.IFilter;

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
  public void addImage(IImage image,int x, int y);


  /**
   * Removes an image from the layer
   * @param image to be removed.
   */
  public void removeImage(IImage image);


  /**
   * This method returns the canvas from the layer.
   */
  public IPixel[][] getCanvas();


}
