package model;


import model.Filters.IFilter;

/**
 * Represents a Layer on the Image.
 * A layer can accept an image and location, in which, the image is placed onto the layer's canvas
 * at said location.
 * The canvas, now holds each pixel from the image on its on canvas, and can be fed more images.
 * If a pixel is overridden on the canvas, it will show the last placed image's pixel.
 */

public class Layer implements ILayer {
  IPixel[][] canvas;
  String name;
  IFilter filter;
  int height;
  int width;

  /**
   * Represents a constructor for a Layer if filter is given.
   *
   * @param name   name of the layer.
   * @param filter filter of the layer.
   * @param height height of the layer.
   * @param width  width of the layer.
   */
  public Layer(String name, IFilter filter, int height, int width) {
    this.name = name;
    this.filter = filter;
    this.height = height;
    this.width = width;
    this.canvas = new IPixel[height][width];
    //creates a blank background for each layer, all white and fully transparent
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.canvas[i][j] = new Pixel(255, 255, 255, 0);
      }
    }
  }

  /*
  /**
   * If no filter is given.
   * @param name name of the layer.
   * @param filter filter of the layer.
   * @param height height of the layer.
   * @param width width of the layer.
   */
  /*
  public Layer(String name, int height, int width) {
    this.name = name;
    this.filter = new Normal();
    this.height = height;
    this.width = width;
    this.canvas = new IPixel[height][width];
    //creates a blank background for each layer, all white and fully transparent
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.canvas[i][j] = new Pixel(255, 255, 255, 0);
      }
    }
  }
  */

  /**
   * Returns the name of the layer.
   *
   * @return name of the layer as a string
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns a pixel given an x and a y.
   *
   * @param x int x coord.
   * @param y int y coord.
   * @return IPixel.
   */
  @Override
  public IPixel getPixel(int x, int y) {
    return this.canvas[x][y];
  }

  /**
   * Returns the filter of the layer.
   *
   * @return IFilter filter.
   */
  @Override
  public IFilter getFilter() {
    return this.filter;
  }

  /**
   * Returns the height of the layer.
   *
   * @return int height.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Returns the width of the layer.
   *
   * @return int width.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Sets the filter for the layer.
   *
   * @param filter to be set.
   */
  public void setFilter(IFilter filter) {
    this.filter = filter;
  }


  /**
   * Adds an image to the layer.
   *
   * @param x     int offset.
   * @param y     int offset.
   * @param image to be added.
   */
  public void addImage(IImage image, int x, int y) throws IllegalArgumentException {
    //FIXME: tbh u gotta check if this works but im pretty sure this is how it works.
    //FIXME: add a invalid argument exception if the x and y given are out of bounds unless we dont care about it. Are we allowing partial images?
    //lets not allow it for now because they didn't specify in assignment
    if (x < 0 || y < 0 || image.getHeight() + y > this.height || image.getWidth() + x > this.width) {
      throw new IllegalArgumentException("invalid bounds for image");
    }

    for (int i = 0; i < image.getHeight() - 1; i++) {
      for (int j = 0; j < image.getWidth() - 1; j++) {
        if (i + x < this.height && j + y < this.width) {
          this.canvas[i + x][j + y] = image.getPixel(i, j);
        }
      }
    }
  }


  /**
   * Sets canvas to all white transparent background.
   */
  public void firstLayer() {
    this.canvas = new IPixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.canvas[i][j] = new Pixel(255, 255, 255, 255);
      }
    }
  }

  /**
   * Returns the canvas of the layer.
   */
  public IPixel[][] getCanvas() {
    return this.canvas;
  }

  /**
   * Sets the canvas of the layer.
   *
   * @param canvas to be set.
   */
  public void setCanvas(IPixel[][] canvas) {
    this.canvas = canvas;
  }
}


//To-Do List.
//constructor that takes in the canvas size (from initial project size), and the name of the layer.
//make array of pixels that is the canvas of the layer (make it a 2d array) (the size of project given by user)
//
//make methods that take in images, and their location (offset), and apply it to the canvas of the layer
// (make sure to check if the image is within the bounds of the canvas) (this will have to iterate thought
// the image's arraylist, and then apply the offsets to add to the arraylist index, to apply the shift.
//make method that applies filter.





