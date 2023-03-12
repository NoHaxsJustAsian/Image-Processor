package model;

import java.util.ArrayList;

import Filters.IFilter;
import Filters.Normal;

public class ImageProcessorModel {
  private int height;
  private int width;
  private int maxValue;
  private ArrayList<Layer> layers;

  ImageProcessorModel(int height, int width, ArrayList<Layer> layers) {
    this.height = height;
    this.width = width;
    this.layers = layers;
  }

  ImageProcessorModel(int height, int width) {
    this(height, width, new ArrayList<Layer>());
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  /**
   * This method will be used to add a layer to the project, with a filter.
   */
  public void addLayer(String name, IFilter filter) {
    // we need to make multiple different types of addLayer methods, where there is a default value set.
    new Layer(name, filter, this.height, this.width);
  }

  /**
   * This method will be used to add a layer to the project, without a filter.
   * This would be the background canvas.
   */
  public void addLayer(String name) {
   this.addLayer(name, new Normal());
  }

  /**
   * This method will set a filter to a layer.
   */
  public void setFilter(Layer name, IFilter filter) {

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

  public void saveImage(file) {
    file.write
  }

  public void saveProject(file) {
    file write ("")
  }



}

arraylist.map
