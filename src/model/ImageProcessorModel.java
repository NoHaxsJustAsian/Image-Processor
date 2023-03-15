package model;

import java.util.ArrayList;
import java.util.HashMap;

import Filters.IFilter;
import Filters.Normal;

public class ImageProcessorModel implements IImageProcessorModel {
  private int height;
  private int width;
  private int maxValue;
  //private ArrayList<ILayer> layers;

  private HashMap<String, ILayer> layers;

  ImageProcessorModel(int height, int width, HashMap<String, ILayer> layers) {
    this.height = height;
    this.width = width;
    this.layers = layers;
  }

  ImageProcessorModel(int height, int width) {
    this(height, width, new HashMap<String, ILayer>());
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  @Override
  public ILayer getLayer(int number) {
    return this.layers.get(number);
  }

  /**
   * This method will be used to add a layer to the project, with a filter.
   */
  public void addLayer(String name, IFilter filter) {
    // we need to make multiple different types of addLayer methods, where there is a default value set.
    this.layers.add(new Layer(name, filter, this.height, this.width));
  }

  /**
   * This method will be used to add a layer to the project, without a filter.
   * This would be the background canvas.
   */
  public void newProject(int height, int width) {
    this.height = height;
    this.width = width;
    this.maxValue = 255;
    this.layers = new ArrayList<ILayer>();
    this.addLayer("background", new Normal());
  }

  /**
   * This method will set a filter to a layer.
   */
  public void setFilter(String name, IFilter filter) {

  }

  /**
   * This method will add an Image to a Layer.
   * @param x
   * @param y
   * @param image
   * @param layer
   */
  public void addImage(int x, int y, IImage image, ILayer layer) {
    layer.addImage(x, y, image);
  }

  public void removeImage(IImage image, ILayer layer) {
    layer.removeImage(image);
  }



}

arraylist.map
