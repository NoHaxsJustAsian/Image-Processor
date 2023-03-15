package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Filters.IFilter;
import model.Filters.Normal;


/**
 * Represents the model for this program.
 */
public class ImageProcessorModel implements IImageProcessorModel {
  private int height;
  private int width;
  private int maxValue;
  private int currentLayer;
  //private final ILayer background = new Layer("background", null, this.height, this.width);
  private HashMap<String, ILayer> nameLayers;
  private List<ILayer> orderLayers;



  /**
   * Represents constructor for this model.
   * (load existing project)
   * @param height int height.
   * @param width int width.
   * @param
   */
  public ImageProcessorModel(int height, int width, HashMap<String, ILayer> nameLayers,
                             List<ILayer> orderLayers) {
    this.height = height;
    this.width = width;
    this.nameLayers = nameLayers;
    this.orderLayers = orderLayers;
  }


//  /**
//   * Represents constructor for this model.
//   * @param height int height.
//   * @param width int width.
//   * @param layers HashMap layers.
//   */
//  ImageProcessorModel(int height, int width, HashMap<String, ILayer> layers) {
//    this.height = height;
//    this.width = width;
//    this.layers = layers;
//  }

  /**
   * Represents a constructor for this model.
   * (new project)
   * @param height int height.
   * @param width int width.
   */
  public ImageProcessorModel(int height, int width) {
    this(height, width, new HashMap<String,ILayer>(), new HashMap<Integer,ILayer>());
  }


//  /**
//   * Represents a constructor for this model.
//   * @param height int height.
//   * @param width int width.
//   */
//  ImageProcessorModel(int height, int width) {
//    this(height, width, new HashMap<String, ILayer> layers);
//  }


  /**
   * This method gets the height of the image.
   * @return int height.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * This method gets the width of the image.
   * @return int width.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * This method gets the maxValue of the image.
   * @return int max value.
   */
  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  /**
   * This method gets the numbered layer from the image using an int key.
   * @param num int layer number.
   * @return ILayer from image.
   */
  @Override
  public ILayer getLayer(int num) {
    return this.orderLayers.get(num);
  }

  /**
   * This method will return the position of a layer in the project given both their layer position.
   *
   * @param i
   * @param j
   */
  @Override
  public void swapLayers(int i, int j) {

  }

  /**
   * This method will return the position of a layer in the project given their names.
   *
   * @param a
   * @param b
   */
  @Override
  public void swapLayers(String a, String b) {

  }

  /**
   * This method gets the layer from the image using a String key.
   * @param string name of layer.
   * @return ILayer from image.
   */
  @Override
  public ILayer getLayer(String string) {
    return this.nameLayers.get(string);
  }

  public int getLayerPosition(ILayer layer) {
    return this.orderLayers.indexOf(layer);
  }

  /**
   * This method will be used to add a layer to the project, with a filter.
   */
  public void addLayer(String name, IFilter filter) {
    // we need to make multiple different types of addLayer methods, where there is a default value set.
    this.nameLayers.put(name, (new Layer(name, filter, this.height, this.width)));
    this.orderLayers.add(this.nameLayers.get(name));
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
    layer.addImage(image, x, y);
  }

  public void removeImage(IImage image, ILayer layer) {
    layer.removeImage(image);
  }

  public void saveImage() {

  }

  public void saveProject() {

  }


}

