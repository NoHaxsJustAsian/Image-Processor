package model;

import java.util.ArrayList;

public class ImageProcessorModel {
  private int height;
  private int width;
  private int maxValue;
  private ArrayList<Layer> Layer;

  ImageProcessorModel(file) {
    this.file = file;
  }

  ImageProcessorModel(int height, int width) {
    this.height = this.height;
    this.width = width;
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

  /*
   * This method will be used to add a layer to the project, without a filter.
   */
  public void addLayer(String name) {
    new Layer(name, null, this.height, this.width);
  }

  /**
   * This method will set a filter to a layer.
   */
  public void setFilter(Layer name, IFilter filter) {

  }

  public void addImage(int x, int y, IImage image, ILayer layer) {
    layer.addImage(x, y, image);
  }

  public void saveImage(file) {
    file.write
  }

  public void saveProject(file) {
    file write ("")
  }


}
