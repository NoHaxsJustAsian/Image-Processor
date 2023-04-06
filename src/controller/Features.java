package controller;

/**
 * Represents the interface which the user uses to interact with the model of the image processor.
 */
public interface Features {
  //File Functions

  /**
   * This method saves a project.
   */
  void saveProject();

  /**
   * This method saves an image.
   */
  void saveImage();

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
   *  This method applies a screen filter to an image.
   */
  void screen(String curLayer);

  //Layer Functions
  /**
   * This method adds a layer to the project.
   */
  void addLayer(String s);

  /**
   * This method adds an image to the layer.
   */
  void addImage(String curLayer);

  /**
   * This method loads a project.
   */
  void loadProject();



}
