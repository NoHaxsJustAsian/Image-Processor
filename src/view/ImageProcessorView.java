package view;

import java.io.IOException;

import model.IImageProcessorModel;

/**
 * Represents a view class for the ImageProcessor.
 */

public class ImageProcessorView implements IImageProcessorView {
  private final IImageProcessorModel model;
  private final Appendable destination;

  /**
   * Creates a view object using the model to display images.
   *
   * @param model the model.
   * @throws IllegalArgumentException if model is null.
   */
  public ImageProcessorView(IImageProcessorModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    this.model = model;
    this.destination = System.out;
  }

  /**
   * Creates a view object using the model and destination appendable to display images.
   *
   * @param model       the model.
   * @param destination the Appendable.
   * @throws IllegalArgumentException if model is null.
   */
  public ImageProcessorView(IImageProcessorModel model, Appendable destination)
          throws IllegalArgumentException {
    if (model == null || destination == null) {
      throw new IllegalArgumentException("Model and/or Appendable cannot be null");
    }
    this.model = model;
    this.destination = destination;
  }

  /**
   * Renders a message to destination.
   *
   * @param message the message to be transmitted.
   * @throws IOException if transmission fails.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.destination.append(message);
    } catch (IOException e) {
      throw new IOException("Transmission failed");
    }
  }

  /**
   * Renders the state of the model.
   *
   * @throws IOException if transmission fails.
   */
  @Override
  public void renderState() throws IOException {

  }


}
