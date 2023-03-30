import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import controller.IImageProcessorController;
import controller.ImageProcessorController;
import model.ImageProcessorModel;
import view.IImageProcessorView;
import view.ImageProcessorView;

/**
 * Main class runs.
 */

public class Main {

  /**
   * This is the main method.
   * @param args input for the controller.
   * @throws IOException if controller is unable to
   *                     successfully read input or transmit output.
   */
  public static void main(String[] args) {
    ImageProcessorModel model = new ImageProcessorModel(400, 400);
    Appendable ap = System.out;
    IImageProcessorView view = new ImageProcessorView(model);
    Readable rd = new InputStreamReader(System.in);
    IImageProcessorController controller = new ImageProcessorController(model, view, rd);
    controller.startProcessor();
    //FIXME: Not sure this is how is works with the appendable for file.



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

      Processor m = new ImageProcessorModel();
      View v = new TextView(m);
      ImageController c = new ImageUserInterface(m, v, a);
      c.goRun();
    } else {
      IView sg = new SwingGUI();
      Processor mo = new PpmProcessor();
      Features con = new Controller(mo, sg);
    }
  }

}

