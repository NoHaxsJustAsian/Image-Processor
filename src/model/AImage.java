package model;

/**
 * Represents an abstract class for Image types.
 */
public class AImage implements IImage {

  Pixel[][] content;
  int height;
  int width;

  AImage(Pixel[][] content, int height,  int width) {
    this.content = content;
    this.height = height;
    this.width = width;
  }

}
