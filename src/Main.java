import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import controller.GUIController;
import controller.IImageProcessorController;
import controller.ImageProcessorController;
import model.IImageProcessorModel;
import model.ImageProcessorModel;
import view.GUIView;
import view.IImageProcessorView;
import view.ImageProcessorView;

/**
 * Main class runs the program.
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
    Readable a = new InputStreamReader(System.in);
    if (args.length > 0) {
      StringBuilder commands = new StringBuilder();

      if (!(args[0].equals("-text") || args[0].equals("-file"))) {
        System.out.println("Please run program with valid input.");
        return;
      }

      if (args[0].equals("-file") && args[1] != null) {
        commands.append("file " + args[1]);
        a = new StringReader(commands.toString());
      }

      if (args[0].equals("-text")) {
        a = new InputStreamReader(System.in);
      }

      IImageProcessorModel m = new ImageProcessorModel(10, 10);
      IImageProcessorView v = new ImageProcessorView(m);
      Readable r = new InputStreamReader(System.in);
      IImageProcessorController c = new ImageProcessorController(m, v, r);
      c.startProcessor();
    } else {
      IImageProcessorModel model = new ImageProcessorModel(10, 10);
      GUIView sg = new GUIView();
      GUIController control = new GUIController(sg, model);
    }
  }
}

