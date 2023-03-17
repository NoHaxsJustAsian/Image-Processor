package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.Filters.BrightenIntensity;
import model.Filters.BrightenLuma;
import model.Filters.BrightenValue;
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
   *
   * @param model  ImageProcessor model.
   * @param view   ImageProcessor view.
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
//  public void startProcessor() {
//    Scanner s = new Scanner(this.object);
//
//  }
  private void readCommand(Scanner scan) {
    String command = scan.next();
    while (!command.equals("q") && !command.equals("Q")) {
      switch (command) {
        case "load":
          this.model.loadProject(scan.next()); //FIXME: add load and save functions
          break;
        case "save":
          this.model.saveProject(scan.next()); //FIXME: all these need catch blocks for the exceptions.
          break;
        case "brighten-luma":
          this.model.setFilter(scan.next(), new BrightenLuma());
          break;
        case "brighten-intensity":
          this.model.setFilter(scan.next(), new BrightenIntensity());
          break;
        case "brighten-value":
          this.model.setFilter(scan.next(), new BrightenValue());
          break;
        case "-file":
          readCommand(fileToScanner(scan.next()));
          break;
        default:
          tryRender("Invalid command entered. Please try again.");
      }


    }

    FileWriter writer = null;
    try {
      //If no full path is given, Java assumes the file
      //is relative to wherever the program is run.
      //IntelliJ runs all programs from their project folder
      writer = new FileWriter("hello.txt");
    } catch (IOException ex) {
      //you can handle opening the file differently
      //from failing to write to it
      System.err.println(ex.getMessage());
    }

    if (writer != null) {
      try {
        writer.write("Hello!");
        writer.close();
      } catch (IOException ex) {
        //handle the transmission failure
      }
    }

  }
}
