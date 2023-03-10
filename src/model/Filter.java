package model;

public class Filter implements IFilter {
  private Layer layer;
  private String command;

  public Filter(Layer layer, String command) {
    this.layer = layer;
    this.command = command;
  }

  public Layer getLayer() {
    return this.layer;
  }

  public String getCommand() {
    return this.command;
  }

  /**
   * TO DO: With this, we have options, we can make a separate class for the brighten math,
   * and then call it here, where we have to just input an argument, or we can just have it done it here.
   *
   */

  public void applyBrightenLuma(int value) {

  }

  public void applyBrightenIntensity(int value) {

  }

  public void applyBrightenValue(int value) {

  }

  //darken
  public void applyDarkenLuma(int value) {

  }

  public void applyDarkenIntensity(int value) {

  }

  public void applyDarkenValue(int value) {

  }

}


/**
 * To Do:
 * Find way to manipulate all of the data on the layer, and apply it to the canvas of the layer.
 */