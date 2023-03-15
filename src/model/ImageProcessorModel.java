package model;

import java.util.ArrayList;

import model.Filters.IFilter;
import model.Filters.Normal;


/**
 * Represents the model for this program.
 */
public class ImageProcessorModel implements IImageProcessorModel {
  private int height;
  private int width;
  private int maxValue;
  private ArrayList<ILayer> layers;

//  private final ILayer background = new Layer("background", null, this.height, this.width);

//  private HashMap<String, ILayer> layers;


  /**
   * Represents constructor for this model.
   * @param height int height.
   * @param width int width.
   * @param layers arraylist layers.
   */
  ImageProcessorModel(int height, int width, ArrayList<ILayer> layers) {
    this.height = height;
    this.width = width;
    this.layers = layers;
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
   * @param height int height.
   * @param width int width.
   */
  ImageProcessorModel(int height, int width) {
    this(height, width, new ArrayList<ILayer>());
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
   * This method gets the numbered layer from the image.
   * @param num int layer number.
   * @return ILayer from image.
   */
  @Override
  public ILayer getLayer(int num) {
    return this.layers.get(num);
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

  public void saveImage() {

  }

  public void saveProject() {

  }


}

