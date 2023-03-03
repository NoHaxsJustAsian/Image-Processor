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

  Layer( String name, IFilter filter, IImage content, int height, int width, int x, int y) {
    
  }


}
