package model;

/**
 * Represents a Layer on the Image.
 */
public class Layer {
  String name;
  IFilter filter;
  IImage content;
  int height;
  int width;
  int x;
  int y;

  Layer(String name, IFilter filter, IImage content, int height, int width, int x, int y) {
    this.name = name;
    this.filter = filter;
    this.content = content;
    this.height = height;
    this.width = width;
    this.x = x;
    this.y = y;
  }

  public void setFilter(IFilter filter) {

  }

  public void addImage(int x, int y, IImage image) {
    content.addImage(x, y, image);
  }

  public void getImage() {

  }




}
