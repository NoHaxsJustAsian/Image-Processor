package model;

/**
 * This class represents a JPG image.
 */
public class JPGImage extends AImage {

    /**
    * Represents a constructor for the JPG image.
    *
    * @param content 2D array of pixels.
    * @param height  int height.
    * @param width   int width.
    */
    public JPGImage(IPixel[][] content, int height, int width) {
      super(content, height, width);
    }
}
