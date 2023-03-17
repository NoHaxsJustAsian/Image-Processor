import java.io.IOException;
import java.io.InputStreamReader;

import controller.IImageProcessorController;
import controller.ImageProcessorController;
import model.IImageProcessorModel;
import model.ImageProcessorModel;
import view.IImageProcessorView;
import view.ImageProcessorView;

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
    ImageProcessorModel model = new ImageProcessorModel(400, 400);
    Appendable ap = System.out;
    IImageProcessorView view = new ImageProcessorView(model, ap);
    Readable rd = new InputStreamReader(System.in);
    IImageProcessorController controller = new ImageProcessorController(model, view, rd);
    controller.startProcessor();
    //FIXME: Not sure this is how is works with the appendable for file.

  }


}