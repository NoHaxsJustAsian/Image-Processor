package model;

import model.Filters.IFilter;

/**
 * Interface for a Layer.
 */
public interface ILayer {

  /**
   * Sets the filter for the layer.
   *
   * @param filter to be set.
   */
  void setFilter(IFilter filter);

  /**
   * Adds an image to the layer.
   *
   * @param x     offset
   * @param y     offset
   * @param image to be added.
   */
  void addImage(IImage image, int x, int y);


  /**
   * Removes an image from the layer
   *
   * @param image to be removed.
   */
  void removeImage(IImage image);

  /**
   * Sets canvas to all white background.
   */
  public void clearLayer();

  /**
   * This method returns the canvas from the layer.
   */
  IPixel[][] getCanvas();

  /**
   * Returns the name of the layer.
   *
   * @return String name.
   */
  String getName();
}
