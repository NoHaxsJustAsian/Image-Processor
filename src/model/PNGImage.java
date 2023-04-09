package model;

/**
 * This class represents a PNG image.
 */
public class PNGImage extends AImage {

    /**
    * Represents a constructor for the PNG image.
    *
    * @param content 2D array of pixels.
    * @param height  int height.
    * @param width   int width.
    */
    public PNGImage(IPixel[][] content, int height, int width) {
      super(content, height, width);
    }
}
