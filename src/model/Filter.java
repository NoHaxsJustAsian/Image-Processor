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

  public void applyBrightenLuma(int value) {
    
  }
}
