package mocks;

import java.io.IOException;

import model.IImageProcessorState;
import view.IImageProcessorView;

/**
 * A mock view for the image processor.
 */
public class ImageProcessorViewMock implements IImageProcessorView {
  private IImageProcessorState state;
  final Appendable log;

  /**
   * Displays the mock game in text view and outputs a log.
   */
  public ImageProcessorViewMock(Appendable log) {
    this.log = log;
  }


  /**`
   * Renders a given message to the data output in the implementation.
   *
   * @param message the message to be printed
   * @throws IOException if the transmission of the message to the data output fails
   */
  public void renderMessage(String message) throws IOException {
    try {
      this.log.append(message).append("\n");
    } catch (Exception e) {
      throw new IOException("Invalid Appendable");
    }
  }

  public void renderState() throws IOException {
    try {
      this.log.append(this.state.toString()).append("\n");
    } catch (Exception e) {
      throw new IOException("Invalid Appendable");
    }
  }
}
