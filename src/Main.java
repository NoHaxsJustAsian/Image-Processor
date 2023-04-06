import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import javax.swing.JFrame;

import controller.IImageProcessorController;
import controller.ImageProcessorController;
import model.ImageProcessorModel;
import view.IImageProcessorView;
import view.ImageProcessorView;

/**
 * Main class runs the program.
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
    }

    JFrame frame = new JFrame();




    /*
     * -file: THe next argument is a path to a script. Print the script out.
     * -gui: Starts the GUI.

    if(args.length > 0) {
      if (args[0].equals("-file")) {
        String filePath = args[1];
        Readable reader = null;
        try {
          reader = new FileReader(filePath);
          Scanner scan = new Scanner(reader);
          while(scan.hasNextLine()) {
            System.out.println(scan.nextLine());
          }
        } catch (FileNotFoundException e) {
          System.out.println("Error reading file");
        }


      } else if (args[0].equals("-text")) {
        try {

        } catch (IOException e) {
          System.out.println("Error reading file");
        }


      } else if (args[0].equals("-gui")) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ImageProcessorView(model));
        frame.pack();
        frame.setVisible(true);
      }
    } else {

    }

     */

  }
}

