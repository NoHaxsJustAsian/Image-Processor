package controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;


import model.IImageProcessorModel;
import view.IImageProcessorView;


/**
 * This class implements the IImageProcessor Controller.
 */
public class ImageProcessorController implements IImageProcessorController {

  private IImageProcessorModel model;
  private IImageProcessorView view;
  private final Readable object;
  private String curLayer;

  /**
   * Represents a controller that reads and execute commands.
   *
   * @param model  ImageProcessor model.
   * @param view   ImageProcessor view.
   * @param object Readable object.
   */
  public ImageProcessorController(IImageProcessorModel model,
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
   *
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
   *
   * @param scan the scanner.
   */
  private void readCommand(Scanner scan) {
    tryRender("Welcome to the Image Processor! \n");
    tryRender("press q or Q to quit! \n");
    tryRender("Possible commands include: \n");
    tryRender("new-project ");
    tryRender("load-project ");
    tryRender("save-project ");
    tryRender("save-image ");
    tryRender("set-filter ");
    tryRender("add-layer ");
    tryRender("add-image-to-layer \n");
    String command = scan.next();
    while (!command.equals("q") && !command.equals("Q")) {
      switch (command) {
        case "new-project":
          tryRender("enter height and width and max color value \n");
          try {
            this.model.newProject(scan.nextInt(), scan.nextInt(), scan.nextInt());
            tryRender("new Project created! \n");
            break;
          } catch (IllegalArgumentException e) {
            tryRender("Invalid height or width or max color value \n");
            break;
          }
        case "load-project":
          tryRender("type project path to load \n");
          this.loadProject(scan.next());
          break;
        case "save-project":
          tryRender("type project path to save \n");
          this.saveProject(scan.next());
          break;
        case "save-image":
          tryRender("type project path to save \n");
          this.saveImage(scan.next(), scan.next());
          break;
        case "select-layer":
          tryRender("type layer name to select \n");
          curLayer = scan.next();
          break;
        case "set-filter":
          tryRender("type filter name \n");
          switch (scan.next()) {
            case "blue":
              this.model.setFilter(scan.next(), model.getFilter("blue"));
              break;
            case "brighten-luma":
              this.model.setFilter(scan.next(), model.getFilter("brighten-luma"));
              break;
            case "brighten-intensity":
              this.model.setFilter(scan.next(), model.getFilter("brighten-intensity"));
              break;
            case "brighten-value":
              this.model.setFilter(scan.next(), model.getFilter("brighten-value"));
              break;
            case "darken-luma":
              this.model.setFilter(scan.next(), model.getFilter("darken-luma"));
              break;
            case "darken-intensity":
              this.model.setFilter(scan.next(), model.getFilter("darken-intensity"));
              break;
            case "darken-value":
              this.model.setFilter(scan.next(), model.getFilter("darken-value"));
              break;
            case "green":
              this.model.setFilter(scan.next(), model.getFilter("green"));
              break;
            case "red":
              this.model.setFilter(scan.next(), model.getFilter("red"));
              break;
            case "multiply":
              this.model.setFilter(scan.next(), model.getFilter("multiply"));
              break;
            case "difference":
              this.model.setFilter(scan.next(), model.getFilter("difference"));
              break;
            case "screen":
              this.model.setFilter(scan.next(), model.getFilter("screen"));
              break;
            default:
              this.model.setFilter(scan.next(), model.getFilter("normal"));
              break;
          }
          break;
        case "add-layer":
          this.model.addLayer(scan.next());
          break;
        case "add-image-to-layer":
          tryRender("type layer name to add image to \n");
          curLayer = scan.next();
          tryRender("type image path to add \n");
          this.loadPPM(scan.next(), scan.nextInt(), scan.nextInt());
          break;
        default:
          tryRender("Invalid command entered. Please try again.");
          command = scan.next();
          break;
      }
    }

  }

  /**
   * This method should load a project.
   *
   * @param filePath the path of the project.
   */
  private void loadProject(String filePath) {
    Scanner sc;

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
      return;
    }

    model.loadProjectHelp(builder.toString());
  }

  private void loadPPM(String imagePath, int x, int y) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(imagePath));
      tryRender("Image loaded successfully");
    } catch (FileNotFoundException e) {
      tryRender("File " + imagePath + " not found!");
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
    if (!token.equals("P3")) {
      tryRender("Invalid PPM file: plain RAW file should begin with P3");
    }
    model.loadPPMHelp(builder.toString(), curLayer, x, y);
  }


  /**
   * This method will output the project as its separate components.
   */
  private void saveProject(String filePath) throws IllegalArgumentException {
    if (filePath == null || !filePath.endsWith(".collage")) {
      throw new IllegalArgumentException("invalid file path");
    }
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new File(filePath));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.println("C1");
    writer.println(model.getWidth() + " " + model.getHeight());
    writer.println(model.getMaxValue());
    for (int x = 0; x < model.getLayerCount(); x++) {
      writer.println(model.getLayer(x).getName()
              + " "
              + model.getLayer(x).getFilter().getName());
      for (int i = 0; i < model.getHeight(); i++) {
        for (int j = 0; j < model.getWidth(); j++) {
          writer.println(model.getLayer(x).getPixel(i, j).getRed()
                  + " " + model.getLayer(x).getPixel(i, j).getGreen()
                  + " " + model.getLayer(x).getPixel(i, j).getBlue());
        }
      }
    }
    writer.close();
  }

  /**
   * This method will create one image from all the layers for PPM.
   */
  private void savePPM(String filePath) throws IllegalArgumentException {
    if (filePath == null || !filePath.endsWith(".ppm")) {
      throw new IllegalArgumentException("invalid file path");
    }
    PrintWriter writer;
    try {
      writer = new PrintWriter(new File(filePath)); //FIXME: fix PrintWriter
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.println(model.savePPMHelp());
    writer.close();
  }


  private void saveImage(String filePath, String fileType) throws IllegalArgumentException {
    if (filePath == null || fileType == null) {
      throw new IllegalArgumentException("invalid file path");
    }
    if (fileType.equals("ppm")) {
      savePPM(filePath);
    } else {
      BufferedImage img = model.compressImage();
      File outputfile = new File("saved." + fileType);
      try {
        ImageIO.write(img, fileType, outputfile);
      } catch (IOException e) {
        tryRender("File " + filePath + " not found! / INVALID");
      }
    }
  }
}
