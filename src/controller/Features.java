package controller;

import java.awt.event.ActionEvent;

public interface Features {
  //File Functions

  /**
   * This method starts a new Project.
   */
  void newProject();

  /**
   * This method loads a project.
   */
  void loadProject();

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
   * This method applies a blue filter to an image.
   */
  void blueFilter();

  /**
   * This method applies a brightenIntensity filter to an image.
   */
  void brightenIntensity();

  /**
   * This method applies a brightenLuma filter to an image.
   */
  void brightenLuma();

  /**
   * This method applies a brightenValue filter to an image.
   */
  void brightenValue();

  /**
   * This method applies a darkenIntensity filter to an image.
   */
  void darkenIntensity();

  /**
   * This method applies a darkenLuma filter to an image.
   */
  void darkenLuma();

  /**
   * This method applies a darkenValue filter to an image.
   */
  void darkenValue();

  /**
   * This method applies a green filter to an image.
   */
  void greenFilter();

  /**
   * This method applies a normal filter to an image.
   */
  void normal();

  /**
   * This method applies a red filter to an image.
   */
  void redFilter();

  /**
   *  This method applies a screen filter to an image.
   */
  void screen();

  /**
   * This method applies a multiply filter to an image.
   */
  void multiply();

  /**
   * This method applies a difference filter to an image.
   */
  void difference();

  //Layer Functions

  /**
   * This method adds a layer to the project.
   */
  void addLayer();

  /**
   * This method adds an image to the layer.
   */
  void addImageToLayer();
}
