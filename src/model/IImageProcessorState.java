package model;

/**
 * Represents a interface for the model.
 */

public interface IImageProcessorState {


  /**
   * This method will return the width of the project.
   * @return int height.
   */
  int getHeight();

  /**
   * This method will return the height of the project.
   * @return int width.
   */
  int getWidth();

  /**
   * This method will return the max value of the project.
   * @return
   */
  int getMaxValue();

  /**
   * This method will return a layer from the project from a String key.
   * @param string name of layer.
   * @return ILayer
   */
  ILayer getLayer(String string);

  /**
   * This method will return a layer from the project from its layer number.
   * @param num int layer number.
   * @return ILayer
   */
  ILayer getLayer(int num);


}
