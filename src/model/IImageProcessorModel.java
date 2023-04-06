package model;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import model.filters.IFilter;

/**
 * Represents an interface for model.
 */
public interface IImageProcessorModel extends IImageProcessorState {

  /**
   * This method will return the position of a layer in the project given both their layer position.
   *
   * @param i layer position.
   * @param j layer position.
   */
  void swapLayers(int i, int j);

  /**
   * This method will return the position of a layer in the project given their names.
   *
   * @param a name of layer.
   * @param b name of layer.
   */
  void swapLayers(String a, String b);


  /**
   * This method will be used to add a layer to the project, with a filter.
   *
   * @param name   name of filter.
   * @param filter type of filter.
   */
  void addLayer(String name, IFilter filter);


  /**
   * This method will be used to add a layer to the project, without a filter.
   * This would be the background canvas.
   *
   * @param height int height.
   * @param width  int width.
   * @param maxValue int max value.
   */
  void newProject(int height, int width, int maxValue);

  /**
   * This method will set a filter to a layer.
   */
  void setFilter(String name, IFilter filter);

  /**
   * This method will add an Image to a Layer.
   *
   * @param x     int pos.
   * @param y     int pos.
   * @param image IImage being added.
   * @param layer Layer image being is added to.
   */
  void addImage(int x, int y, IImage image, ILayer layer);



  /**
   * This image will produce the final canvas for all layers for PPM.
   *
   * @return IPixel[][] finalPixels.
   */
  IPixel[][] saveCanvas();


  /**
   * This method will return the list of layers in the project.
   *
   * @return String list of layers.
   */
  public String listLayers();

  /**
   * This method will return the list of filters in the project.
   * @return
   */
  public int getLayerCount();

  /**
   * This method will return a map of all layers in the project.
   *
   * @return list of Layers.
   */
  public HashMap<String,ILayer> getMapLayers();

  /**
   * This method will return a BufferedImage of the final canvas.
   */
  public BufferedImage compressImage();
}
