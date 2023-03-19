package controller;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import model.Filters.BlueFilter;
import model.Filters.BrightenIntensity;
import model.Filters.BrightenLuma;
import model.Filters.BrightenValue;
import model.Filters.DarkenIntensity;
import model.Filters.DarkenLuma;
import model.Filters.DarkenValue;
import model.Filters.GreenFilter;
import model.Filters.IFilter;
import model.Filters.Normal;
import model.Filters.RedFilter;
import model.IImageProcessorModel;

import model.ILayer;
import model.IPixel;
import model.ImageProcessorModel;
import model.Layer;
import model.Pixel;
import view.IImageProcessorView;
import view.ImageProcessorView;


/**
 * This class implements the IImageProcessor Controller.
 */
public class ImageProcessorController implements IImageProcessorController {

  int width;
  int height;
  ImageProcessorModel model;
  private IImageProcessorView view;
  private final Readable object;


  /**
   * Represents a controller that reads and execute commands.
   *
   * @param model  ImageProcessor model.
   * @param view   ImageProcessor view.
   * @param object Readable object.
   */
  public ImageProcessorController(ImageProcessorModel model,
                                  IImageProcessorView view, Readable object) {
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
    readCommand(s);
  }

  /**
   * This method should load a project.
   * @param message the path of the project.
   */
  private void tryRender(String message) {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      System.out.println("Error rendering");
    }
  }

  /**
   * This method should load a project.
   * @param scan the scanner.
   */
  private void readCommand(Scanner scan) {
    String command = scan.next();
    while (!command.equals("q") && !command.equals("Q")) {
      switch (command) {
        case "new":
          tryRender("enter height and width");
          try {
            this.model.newProject(scan.nextInt(), scan.nextInt()); //FIXME: add load and save functions
            break;
          } catch (IllegalArgumentException e) {
            tryRender("Invalid height or width");
            break;
          }
        case "load":
          tryRender("type project path to load");
          this.loadProject(scan.next()); //FIXME: add load and save functions also figure out what the file path is
          break;
        case "save":
          tryRender("type project path to save");
          this.model.saveProject(scan.next()); //FIXME: all these need catch blocks for the exceptions.
          break;
        case "blue":
          this.model.setFilter(scan.next(), new BlueFilter());
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
        case "darken-luma":
          this.model.setFilter(scan.next(), new DarkenLuma());
          break;
        case "darken-intensity":
          this.model.setFilter(scan.next(), new DarkenIntensity());
          break;
        case "darken-value":
          this.model.setFilter(scan.next(), new DarkenValue());
          break;
        case "green":
          this.model.setFilter(scan.next(), new GreenFilter());
          break;
        case "normal":
          this.model.setFilter(scan.next(), new Normal());
          break;
        case "red":
          this.model.setFilter(scan.next(), new RedFilter());
          break;
        default:
          tryRender("Invalid command entered. Please try again.");
          command = scan.next();
          break;
      }
    }

//    FileWriter writer = null;
//    try {
//      //If no full path is given, Java assumes the file
//      //is relative to wherever the program is run.
//      //IntelliJ runs all programs from their project folder
//      writer = new FileWriter("hello.txt");
//    } catch (IOException ex) {
//      //you can handle opening the file differently
//      //from failing to write to it
//      System.err.println(ex.getMessage());
//    }
//
//    if (writer != null) {
//      try {
//        writer.write("Hello!");
//        writer.close();
//      } catch (IOException ex) {
//        //handle the transmission failure
//      }
//    }
  }

  /**
   * This method should load a project.
   * @param filePath the path of the project.
   */
  private void loadProject(String filePath) {
    Scanner sc;
    int width;
    int height;
    int maxRGB;
    ImageProcessorModel model;
    IFilter filter;
    List<ILayer> orderLayers = new ArrayList<ILayer>();
    HashMap<String,ILayer> nameLayers = new HashMap<String,ILayer>();
    IPixel[][] pixels;

    try {
      sc = new Scanner(new FileInputStream(filePath));
    } catch (FileNotFoundException e) {
      this.tryRender("File " + filePath + " not found!");
      return;
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (!s.equals("") && s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("C1")) {
      this.tryRender("Invalid Collage file: Collage file should begin with C1");
    }
    width = sc.nextInt();
    height = sc.nextInt();
    maxRGB = sc.nextInt();
    while(sc.hasNext()) {
      String name = sc.next();
      try {
        filter = filterHelp(sc.next()); //FIXME: fix naming scheme of filters
      }
      catch(IllegalArgumentException e) {
        this.tryRender("Invalid filter name");
        return;
      }
      pixels = new Pixel[height][width];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int r = sc.nextInt();
          int g = sc.nextInt();
          int b = sc.nextInt();
          pixels[i][j] = new Pixel(r, g, b, 255);
        }
      }
      ILayer hold = new Layer(name, filter, height, width);
      hold.setCanvas(pixels);
      orderLayers.add(hold);
      nameLayers.put(name, hold);
    }
    this.model = new ImageProcessorModel(height, width, nameLayers, orderLayers);
    this.view = new ImageProcessorView(this.model);
  }

  /**
   * This method should load a project.
   * @param name the name of the filter.
   */
  private IFilter filterHelp(String name) {
    switch(name) {
      case "blue":
        return new BlueFilter();
      case "brighten-luma":
        return new BrightenLuma();
      case "brighten-intensity":
        return new BrightenIntensity();
      case "brighten-value":
        return new BrightenValue();
      case "darken-luma":
        return new DarkenLuma();
      case "darken-intensity":
        return new DarkenIntensity();
      case "darken-value":
        return new DarkenValue();
      case "green":
        return new GreenFilter();
      case "normal":
        return new Normal();
      case "red":
        return new RedFilter();
      default:
        return null;
    }
  }
}
