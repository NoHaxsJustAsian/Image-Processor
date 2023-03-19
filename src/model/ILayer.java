package model;

import model.Filters.IFilter;

/**
 * Interface for a Layer.
 */
public interface ILayer {

  /**
   * Returns the height of the layer.
   *
   * @return int height.
   */
  int getHeight();

  /**
   * Returns the width of the layer.
   *
   * @return int width.
   */
  int getWidth();

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


//  /**
//   * Removes an image from the layer
//   *
//   * @param image to be removed.
//   */
//  void removeImage(IImage image);

  /**
   * Sets canvas to all white background.
   */
  public void firstLayer();

  /**
   * This method returns the canvas from the layer.
   *
   * @return 2D array of pixels.
   */
  public IPixel[][] getCanvas();

  /**
   * Returns the name of the layer.
   *
   * @return String name.
   */
  String getName();

  /**
   * Returns a pixel given an x and a y.
   *
   * @param x int x coord.
   * @param y int y coord.
   * @return
   */
  IPixel getPixel(int x, int y);

  /**
   * Returns the filter of the layer.
   *
   * @return IFilter filter.
   */
  IFilter getFilter();

  /**
   * sets the canvas of the layer.
   *
   * @param canvas
   */
  public void setCanvas(IPixel[][] canvas);
}
