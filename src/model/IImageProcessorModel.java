package model;

import model.Filters.IFilter;

/**
 * Represents an interface for model.
 */
public interface IImageProcessorModel extends IImageProcessorState {

  /**
   * This method will be used to add a layer to the project, with a filter.
   */
  public void addLayer(String name, IFilter filter);

  /**
   * This method will be used to add a layer to the project, without a filter.
   * This would be the background canvas.
   */
  public void newProject(int height, int width);

  /**
   * This method will set a filter to a layer.
   */
  public void setFilter(String name, IFilter filter);

  /**
   * This method will add an Image to a Layer.
   * @param x int pos.
   * @param y int pos.
   * @param image IImage being added.
   * @param layer Layer image being is added to.
   */
  public void addImage(int x, int y, IImage image, ILayer layer);

  /**
   * This method will return a layer from the project from a String key.
   * @param string
   * @return
   */
  public ILayer getLayer(String string);

  /**
   * This method will return a layer from the project from an int key.
   * @param int
   * @return
   */
  public ILayer getLayer(Integer int);

  /**
   * This method wil remove an Image from a Layer.
   * @param image IImage being removed.
   * @param layer Layer image being is removed from.
   */
  public void removeImage(IImage image, ILayer layer);


  public void saveImage();

  public void saveProject();


}
