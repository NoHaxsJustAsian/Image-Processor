package controller;
import java.util.Scanner;

import model.IImageProcessorModel;

import model.ImageProcessorModel;
import view.IImageProcessorView;


/**
 * This class implements the IImageProcessor Controller.
 */
public class ImageProcessorController implements IImageProcessorController {

  int width;
  int height;

  ImageProcessorModel model = new ImageProcessorModel(height, width);

  private IImageProcessorView view;

  private Readable object;


  /**
   * Represents a controller that reads and execute commands.
   * @param model ImageProcessor model.
   * @param view ImageProcessor view.
   * @param object Readable object.
   */
  public ImageProcessorController(ImageProcessorModel model, IImageProcessorView view, Readable object) {
    if (model == null || view == null || object == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.model = model;
    this.view = view;
    this.object = object;
  }


  /**
   * This method should start a new Program.
   */
  public void startProcessor() {
    Scanner s = new Scanner(this.object);

  }

  private void readCommand(Scanner scan) {
    String command = scan.next();
    while (!command.equals("q") && !command.equals("Q")) {
      switch (command) {
        case "load":
          this.load(scan.next(), scan.next()); //FIXME: add load and save functions
          break;
        case "save":
          this.save(scan.next(), scan.next()); //FIXME: all these need catch blocks for the exceptions.
          break;
        case "brighten":
          this.model.brighten(scan.nextInt(), scan.next(), scan.next());
          break;
        case "vertical-flip":
          this.model.flip(false, scan.next(), scan.next());
          break;
        case "horizontal-flip":
          this.model.flip(true, scan.next(), scan.next());
          break;
        case "-file":
          readCommand(fileToScanner(scan.next()));
          break;
        default:
          tryRender("Invalid command entered. Please try again.");
      }
}
