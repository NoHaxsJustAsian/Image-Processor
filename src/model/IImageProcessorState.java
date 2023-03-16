package model;

/**
 * Represents a interface for the model.
 */

public interface IImageProcessorState {

  /**
   * This method gets the height of the image.
Í   * @return int height.
   */
  public int getHeight();

  /**
   * This method gets the width of the image.
   * @return int width.
   */
  public int getWidth();

  /**
   * This method gets the maxValue of the image.
   * @return int max value.
   */
  public int getMaxValue();

  /**
   * This method gets the numbered layer from the image.
   * @param num int layer number.
   * @return ILayer from image.
   */
  public ILayer getLayer(int num);



}
