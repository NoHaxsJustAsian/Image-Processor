package model;

import model.filters.IFilter;

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
   * @param x     offset.
   * @param y     offset.
   * @param image to be added.
   */
  void addImage(IImage image, int x, int y);


  /**
   * Sets canvas to all white background.
   */
  public void firstLayer();

  /**
   * Returns the canvas of the layer.
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
   * Sets the canvas of the layer.
   *
   * @param canvas 2D array of pixels.
   */
  public void setCanvas(IPixel[][] canvas);
}
