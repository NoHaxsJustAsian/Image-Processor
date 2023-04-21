package controller;

import java.io.IOException;

/**
 * Represents the interface which the user uses to interact with the model of the image processor.
 */
public interface Features {

  /**
   * This method saves a project.
   */
  void saveProject();

  /**
   * This method saves an image.
   */
  void saveImage(String fileType) throws IOException;

  //Filter Functions

  /**
   * This method applies a red filter to an image.
   */
  void redFilter(String curLayer);

  /**
   * This method applies a green filter to an image.
   */
  void greenFilter(String curLayer);

  /**
   * This method applies a blue filter to an image.
   */
  void blueFilter(String curLayer);

  /**
   * This method applies a brightenIntensity filter to an image.
   */
  void brightenIntensity(String curLayer);

  /**
   * This method applies a brightenLuma filter to an image.
   */
  void brightenLuma(String curLayer);

  /**
   * This method applies a brightenValue filter to an image.
   */
  void brightenValue(String curLayer);

  /**
   * This method applies a darkenIntensity filter to an image.
   */
  void darkenIntensity(String curLayer);

  /**
   * This method applies a darkenLuma filter to an image.
   */
  void darkenLuma(String curLayer);

  /**
   * This method applies a darkenValue filter to an image.
   */
  void darkenValue(String curLayer);

  /**
   * This method applies a normal filter to an image.
   */
  void normal(String curLayer);

  /**
   * This method applies a multiply filter to an image.
   */
  void multiply(String curLayer);

  /**
   * This method applies a difference filter to an image.
   */
  void difference(String curLayer);

  /**
   * This method applies a screen filter to an image.
   */
  void screen(String curLayer);

  /**
   * This method adds a layer to the project.
   */
  void addLayer(String s);

  /**
   * This method adds a PPM image to the layer.
   * @param curLayer the current layer.
   * @param x the x coordinate.
   * @param y the y coordinate.
   */
  void addPPM(String curLayer, int x, int y);

  /**
   * This method loads a project.
   */
  void loadProject();

  /**
   * This saves an image as a ppm.
   */
  void savePPM();

  /**
   * This loads an image.
   * @param curLayer the current layer.
   * @param x the x coordinate.
   * @param y the y coordinate.
   */
  void addImage(String curLayer, int x, int y);

  /**
   * This method makes a new project.
   */
  void newProject(int height, int width, int maxValue);

}
