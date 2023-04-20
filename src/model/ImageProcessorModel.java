package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Filters
import model.filters.BlueFilter;
import model.filters.BrightenIntensity;
import model.filters.BrightenLuma;
import model.filters.BrightenValue;
import model.filters.DarkenIntensity;
import model.filters.DarkenLuma;
import model.filters.DarkenValue;
import model.filters.Difference;
import model.filters.GreenFilter;
import model.filters.IFilter;
import model.filters.Multiply;
import model.filters.Normal;
import model.filters.RedFilter;
import model.filters.Screen;

/**
 * Represents the model for this program.
 */
public class ImageProcessorModel implements IImageProcessorModel {
  private int height;
  private int width;
  private int maxValue;
  private HashMap<String, ILayer> nameLayers;
  private List<ILayer> orderLayers;

  /**
   * Represents constructor for this model.
   * (load existing project)
   *
   * @param height      int height.
   * @param width       int width.
   * @param nameLayers  HashMap of layers with keys as names.
   * @param orderLayers List of layers.
   */
  public ImageProcessorModel(int height, int width, HashMap<String, ILayer> nameLayers,
      List<ILayer> orderLayers, int maxValue) {
    if (height < 0 || width < 0 || nameLayers == null || orderLayers == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
    this.nameLayers = nameLayers;
    this.orderLayers = orderLayers;
  }

  /**
   * Represents constructor for this model.
   * (load existing project)
   *
   * @param height      int height.
   * @param width       int width.
   * @param nameLayers  HashMap of layers with keys as names.
   * @param orderLayers List of layers.
   */
  public ImageProcessorModel(int height, int width, HashMap<String, ILayer> nameLayers,
      List<ILayer> orderLayers) {
    this(height, width, nameLayers, orderLayers, 255);
  }

  /**
   * Represents a constructor for this model.
   * (new project)
   *
   * @param height int height.
   * @param width  int width.
   */
  public ImageProcessorModel(int height, int width) {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
    this.nameLayers = new HashMap<String, ILayer>();
    this.orderLayers = new ArrayList<ILayer>();
    this.addLayer("background", new Normal());
  }

  /**
   * This method gets the height of the image.
   *
   * @return int height.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * This method gets the width of the image.
   *
   * @return int width.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * This method gets the maxValue of the image.
   *
   * @return int max value.
   */
  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  /**
   * This method gets the layer from the project using a String key.
   *
   * @param string name of layer.
   * @return ILayer
   * @throws IllegalArgumentException if the layer does not exist.
   */
  @Override
  public ILayer getLayer(String string) throws IllegalArgumentException {
    if (!this.nameLayers.containsKey(string)) {
      throw new IllegalArgumentException("The layer does not exist.");
    }
    return this.nameLayers.get(string);
  }

  /**
   * This method gets the numbered layer from the image using an int key.
   *
   * @param num int layer number.
   * @return ILayer from image.
   */
  @Override
  public ILayer getLayer(int num) throws IllegalArgumentException {
    if (num < 0 || num >= this.orderLayers.size()) {
      throw new IllegalArgumentException("The layer does not exist.");
    }
    return this.orderLayers.get(num);
  }

  /**
   * This method will return all the layers from the project.
   *
   * @return list of Layers.
   */
  @Override
  public List<ILayer> getLayers() {
    return this.orderLayers;
  }

  /**
   * This method will return a map of all layers in the project.
   *
   * @return list of Layers.
   */
  @Override
  public HashMap<String, ILayer> getMapLayers() {
    return this.nameLayers;
  }

  /**
   * This method will return the position of a layer in the project given both
   * their layer position.
   *
   * @param i layer position.
   * @param j layer position.
   */
  @Override
  public void swapLayers(int i, int j) {
    Collections.swap(this.orderLayers, i, j);
  }

  /**
   * This method will return the position of a layer in the project given their
   * names.
   *
   * @param a name of layer.
   * @param b name of layer.
   * @throws IllegalArgumentException if the layers do not exist or if they are
   *                                  already in position.
   */
  @Override
  public void swapLayers(String a, String b) throws IllegalArgumentException {
    if (!this.nameLayers.containsKey(a) || !this.nameLayers.containsKey(b)) {
      throw new IllegalArgumentException("One of the layers does not exist.");
    }
    // FIXME: check if this is correct.
    if (this.getLayerPosition(this.getLayer(a).getName()) == this.getLayerPosition(this.getLayer(b).getName())) {
      throw new IllegalArgumentException("The layers are already in the same position.");
    }

    Collections.swap(this.orderLayers, this.orderLayers.indexOf(this.getLayer(a)),
        this.orderLayers.indexOf(this.getLayer(b)));
  }

  /**
   * This method will return the position of a layer in the project given its
   * name.
   *
   * @param string name of layer.
   * @return int position of layer.
   * @throws IllegalArgumentException if the layer does not exist.
   */
  public int getLayerPosition(String string) throws IllegalArgumentException {
    if (!this.nameLayers.containsKey(string)) {
      throw new IllegalArgumentException("The layer does not exist.");
    }

    return this.orderLayers.indexOf(this.getLayer(string));
  }

  /**
   * This method will return the position of a layer in the project given its
   * layer.
   *
   * @param name   name of filter.
   * @param filter type of filter.
   * @throws IllegalArgumentException if the layer already exists.
   */
  public void addLayer(String name, IFilter filter) throws IllegalArgumentException {
    if (this.nameLayers.containsKey(name)) {
      throw new IllegalArgumentException("The layer already exists.");
    }
    this.nameLayers.put(name, (new Layer(name, filter, this.height, this.width)));
    this.orderLayers.add(this.nameLayers.get(name));
  }

  /**
   * This method will return the position of a layer in the project given its
   * layer.
   *
   * @param name name of filter.
   * @throws IllegalArgumentException if the layer already exists.
   */
  public void addLayer(String name) throws IllegalArgumentException {
    if (this.nameLayers.containsKey(name)) {
      throw new IllegalArgumentException("The layer already exists.");
    }
    this.nameLayers.put(name, (new Layer(name, new Normal(), this.height, this.width)));
    this.orderLayers.add(this.nameLayers.get(name));
  }

  /**
   * This method will be used to add a layer to the project, without a filter.
   * This would be the background canvas.
   */
  public void newProject(int height, int width, int maxValue) {
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
    this.nameLayers = new HashMap<String, ILayer>();
    this.orderLayers = new ArrayList<ILayer>();
    this.addLayer("background", new Normal());
  }

  /**
   * This method will set a filter to a layer.
   *
   * @param name name of layer.
   * @throws IllegalArgumentException if the layer does not exist.
   */
  public void setFilter(String name, IFilter filter) throws IllegalArgumentException {
    if (!this.nameLayers.containsKey(name)) {
      throw new IllegalArgumentException("The layer does not exist.");
    }
    this.getLayer(name).setFilter(filter);
  }

  /**
   * This method will add an Image to a Layer.
   *
   * @param x     int x position.
   * @param y     int y position.
   * @param image IImage image.
   * @param layer ILayer layer.
   */
  public void addImage(int x, int y, IImage image, ILayer layer) throws IllegalArgumentException {
    if (x > this.width || x < 0 || y > this.height || y < 0) {
      throw new IllegalArgumentException("invalid arguments");
    }
    layer.addImage(image, x, y);
  }

  /**
   * This image will produce the final canvas for all layers for PPM.
   *
   * @return IPixel[][] finalPixels.
   */
  public IPixel[][] saveCanvas() {
    IPixel[][] finalPixels = new IPixel[getHeight()][getWidth()];
    for (int x = 0; x < orderLayers.size(); x++) {
      ILayer layer = orderLayers.get(x);
      layer.setCanvas(layer.getFilter().apply(orderLayers, layer));
      for (int i = 0; i < getHeight(); i++) {
        for (int j = 0; j < getWidth(); j++) {
          finalPixels[i][j] = orderLayers.get(x).getPixel(i, j);
        }
      }
    }
    return finalPixels;
  }

  /**
   * This method will return the list of layers in the project.
   *
   * @return String list of layers.
   */
  public String listLayers() {
    return String.join(",", nameLayers.keySet());
  }

  /**
   * This method will return the list of filters in the project.
   *
   * @return String list of filters.
   */
  public int getLayerCount() {
    return orderLayers.size();
  }

  /**
   * This method will return the list of filters in the project.
   *
   * @return String list of filters.
   */
  public BufferedImage compressImage() {
    BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        IPixel[][] finalPixels = this.saveCanvas();
        int r = finalPixels[i][j].getRed();
        int g = finalPixels[i][j].getGreen();
        int b = finalPixels[i][j].getBlue();
        int a = finalPixels[i][j].getAlpha();

        int argb = a << 24;
        argb |= r << 16;
        argb |= g << 8;
        argb |= b;

        image.setRGB(j, i, argb);
      }
    }
    return image;
  }

  /**
   * This method will return the filter when given the name of the filter.
   * 
   * @param name name of filter.
   * @return IFilter
   */
  public IFilter getFilter(String name) {
    switch (name) {
      case "blue":
        return new BlueFilter();
      case "brighten-luma":
        return new BrightenLuma();
      case "brighten-intensity":
        return new BrightenIntensity();
      case "brighten-value":
        return new BrightenValue();
      case "darken-luma":
        return new DarkenLuma();
      case "darken-intensity":
        return new DarkenIntensity();
      case "darken-value":
        return new DarkenValue();
      case "green":
        return new GreenFilter();
      case "normal":
        return new Normal();
      case "red":
        return new RedFilter();
        case "multiply":
        return new Multiply();
      case "difference":
        return new Difference();
      case "screen":
        return new Screen();
      default:
        return null;
    }
  }

  /**
   * This method will help the load an existing project.
   */
  public void loadProjectHelp(String totalInput) {
    List<ILayer> orderLayers = new ArrayList<ILayer>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();
    String[] lineNum = totalInput.split("\n");
    int width = Integer.parseInt(lineNum[1].substring(0, lineNum[1].indexOf(" ")));
    int height = Integer.parseInt(lineNum[1].substring(lineNum[1].indexOf(" "), lineNum[1].length()));
    int maxValue = Integer.parseInt(lineNum[2]);

    for (int i = 3; i > lineNum.length; i = i + 2 + height) {
      String name = lineNum[i];
      IFilter filter = this.getFilter(lineNum[i + 1]);
      IPixel pixels[][] = new Pixel[height][width];
      for (int j = 0; j < height; j++) {
        for (int k = 0; k < width; k++) {
          String[] rgb = lineNum[i + 2 + j].split(" ");
          int r = Integer.parseInt(rgb[0]);
          int g = Integer.parseInt(rgb[1]);
          int b = Integer.parseInt(rgb[2]);
          pixels[j][k] = new Pixel(r, g, b, 255);
        }
      }
      ILayer hold = new Layer(name, filter, height, width);
      hold.setCanvas(pixels);
      orderLayers.add(hold);
      nameLayers.put(name, hold);
    }
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
    this.nameLayers = nameLayers;
    this.orderLayers = orderLayers;
  }

  /**
   * This method will help the load a PPM Image.
   */
  public void loadPPMHelp(String totalInput, String curLayer, int x, int y) {
    int width;
    int height;
    int maxValue;
    IPixel[][] pixels;
    String[] lineNum = totalInput.split("\n");

    width = Integer.parseInt(lineNum[1].substring(0, lineNum[1].indexOf(" ")));
    height = Integer.parseInt(lineNum[1].substring(lineNum[1].indexOf(" "), lineNum[1].length()));
    maxValue = Integer.parseInt(lineNum[2]);
    pixels = new Pixel[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        String[] rgb = lineNum[i + 2 + j].split(" ");
        int r = Integer.parseInt(rgb[0]);
        int g = Integer.parseInt(rgb[1]);
        int b = Integer.parseInt(rgb[2]);
        pixels[i][j] = new Pixel(r, g, b, 255);
      }
    }
    addImage(x, y, new PPMImage(pixels, height, width), getLayer(curLayer));
  }

  /**
   * This method will help the load a image that is not PPM.
   */
  public void loadImageHelp(BufferedImage image, String curLayer, int x, int y) {
    int width = image.getWidth();
    int height = image.getHeight();
    Pixel[][] pixels = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int rgb = image.getRGB(j, i);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb & 0xFF);
        pixels[i][j] = new Pixel(r, g, b, 255);
      }
    }
    addImage(x, y, new PPMImage(pixels, height, width), getLayer(curLayer));
  }
  
  /**
   * This method will help save the final image as a PPM.
   */
  public String savePPMHelp() {
    StringBuilder sb = new StringBuilder();
    IPixel[][] finalPixels = this.saveCanvas();
    sb.append("P3" + "\n");
    sb.append(this.width + " " + this.height + "\n");
    sb.append(this.maxValue + "\n");
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        sb.append(finalPixels[i][j].getRed()
                + " " + finalPixels[i][j].getGreen()
                + " " + finalPixels[i][j].getBlue() + "\n");
      }
    }
    return sb.toString();
  }
}
