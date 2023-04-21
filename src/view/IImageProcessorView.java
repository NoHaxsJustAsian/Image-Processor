package view;

import java.io.IOException;

/**
 * Represents the View interface for the program. It is responsible for displaying images
 * using the provided model
 */
public interface IImageProcessorView {

  /**
   * Produces a textual view of an image to be read from.
   */
  void renderMessage(String message) throws IOException;


}
