import java.io.IOException;

import controller.IImageProcessorController;
import controller.ImageProcessorController;
import model.IImageProcessorModel;
import model.ImageProcessorModel;

/**
 * 
 */

public class Main {

  /**
   * This is the main method.
   *
   * @param args input for the controller.
   * @throws IOException if controller is unable to
   *                     successfully read input or transmit output.
   */
  public static void main(String[] args) {

    ImageProcessorModel model = new ImageProcessorModel(); // FIXME: input height width
    IImageProcessorController controller = new ImageProcessorController();

  }


}