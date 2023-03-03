package model;

public class PPMImage extends AImage {
  Colors[][] content;
  int height;
  int width;

  PPMImage(Colors[][] content, int height,  int width) {
    this.content = content;
    this.height = height;
    this.width = width;
  }



}
