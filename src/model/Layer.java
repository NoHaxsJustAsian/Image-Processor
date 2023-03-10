package model;

/**
 * Represents a Layer on the Image.
 * A layer can accept an image and location, in which, the image is placed onto the layer's canvas
 * at said location.
 * The canvas, now holds each pixel from the image on its on canvas, and can be fed more images.
 * If a pixel is overridden on the canvas, it will show the last placed image's pixel.
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




//To-Do List.
//constructor that takes in the canvas size (from initial project size), and the name of the layer.
//make array of pixels that is the canvas of the layer (make it a 2d array) (the size of project given by user)
//
//make methods that take in images, and their location (offset), and apply it to the canvas of the layer
// (make sure to check if the image is within the bounds of the canvas) (this will have to iterate thought
// the image's arraylist, and then apply the offsets to add to the arraylist index, to apply the shift.
//make method that applies layer.


