package model;


import java.util.HashMap;
import java.util.List;

/**
 * Represents an interface for the model.
 */

public interface IImageProcessorState {


  /**
   * This method will return the width of the project.
   *
   * @return int height.
   */
  int getHeight();

  /**
   * This method will return the height of the project.
   *
   * @return int width.
   */
  int getWidth();

  /**
   * This method will return the max value of the project.
   *
   * @return int max value.
   */
  int getMaxValue();

  /**
   * This method will return a layer from the project from a String key.
   *
   * @param string name of layer.
   * @return ILayer
   */
  ILayer getLayer(String string);

  /**
   * This method will return a layer from the project from its layer number.
   *
   * @param num int layer number.
   * @return ILayer
   */
  ILayer getLayer(int num);

  /**
   * This method will return all the layers from the project.
   *
   * @return list of Layers.
   */
  List<ILayer> getLayers();


  /**
   * This method will return the number of layers in the project.
   *
   * @return int number of layers.
   */
  HashMap<String,ILayer> getMapLayers();


  /**
   * This method will return the position of a layer in the project given their names.
   *
   * @param name name of layer.
   * @return int position of layer.
   */
  int getLayerPosition(String name);

  /**
   * This method will return the list of layers in the project.
   *
   * @return String list of layers.
   */
  String listLayers();


  /**
   * This method will return the number of layers in the project.
   *
   * @return int number of layers.
   */
  int getLayerCount();


}
