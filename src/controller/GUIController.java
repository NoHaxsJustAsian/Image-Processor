package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import model.IImageProcessorModel;
import view.GUIView;



/**
 * Represents the controller for the GUI view. This controller will be used to control the GUI view.
 * It will be able to load a project, save a project, and apply filters to the project.
 */
public class GUIController implements Features {

  private GUIView view;
  private IImageProcessorModel model;


  /**
   * Represents the default constructor for the GUIController.
   *
   * @param view  the view.
   * @param model the model.
   */
  public GUIController(GUIView view, IImageProcessorModel model) {
    this.view = view;
    this.model = model;
    this.view.addFeatures(this);
    this.view.display();
  }


  /**
   * This method should load a project and set the model to the project.
   */
  public void loadProject() {
    Scanner sc;
    File f = view.loadProject();
    try {
      sc = new Scanner(new FileInputStream(f));
    } catch (FileNotFoundException e) {
      this.tryRenderMessage("File " + f.getAbsolutePath() + " not found!");
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
      this.tryRenderMessage("Invalid Collage file: Collage file should begin with C1");
      return;
    }

    model.loadProjectHelp(builder.toString());
  }


  /**
   * This method saves a project to a file.
   */
  @Override
  public void saveProject() {
    File f = view.saveFile();

    PrintWriter writer = null;
    try {
      writer = new PrintWriter(f);
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
   * This method saves the final composite Image to a file.
   */
  @Override
  public void savePPM() {
    File f = view.saveFile();

    PrintWriter writer;
    try {
      writer = new PrintWriter(f);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.println(model.savePPMHelp());
    writer.close();
  }

  /**
   * This method applies a blue filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void blueFilter(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("blue"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a brightenIntensity filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void brightenIntensity(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("brighten-intensity"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a brightenLuma filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void brightenLuma(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("brighten-luma"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a brightenValue filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void brightenValue(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("brighten-value"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a darkenIntensity filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void darkenIntensity(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("darken-intensity"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a darkenLuma filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void darkenLuma(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("darken-luma"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a darkenValue filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void darkenValue(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("darken-value"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a green filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void greenFilter(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("green"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a normal filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void normal(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("normal"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a red filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void redFilter(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("red"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a screen filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void screen(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("screen"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a multiply filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void multiply(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("multiply"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method applies a multiply filter to the current layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void difference(String curLayer) {
    try {
      model.setFilter(curLayer, model.getFilter("difference"));
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose a layer.");
    }
  }

  /**
   * This method adds a blank layer to the project.
   */
  @Override
  public void addLayer(String name) {
    model.addLayer(name, model.getFilter("normal"));
  }

  /**
   * This method adds an image to the layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void addPPM(String curLayer, int x, int y) {
    Scanner sc;
    File f = view.addImageToLayer();

    try {
      sc = new Scanner(new FileInputStream(f));
      tryRenderMessage("Image loaded successfully");
    } catch (FileNotFoundException e) {
      tryRenderMessage("File " + f.getAbsolutePath() + " not found!");
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
      tryRenderMessage("Invalid PPM file: plain RAW file should begin with P3");
    }
    
    model.loadPPMHelp(builder.toString(), curLayer, x, y);
  }

  /**
   * This method renders a message using the view, as a popup.
   *
   * @param msg is the given message as a String.
   */
  public void tryRenderMessage(String msg) {
    try {
      this.view.renderMessage(msg);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Message could not be rendered");
    }
  }


  /**
   * This method saves the image to a file.
   * Works for ANY file type.
   */
  public void addImage(String curLayer, int x, int y) {
    BufferedImage image;
    File f = view.addImageToLayer();
    if (f.getAbsolutePath().endsWith(".ppm")) {
      addPPM(curLayer, x, y);
      view.addImageToGUI(model.compressImage());
      return;
    }
    try {
      image = ImageIO.read(new FileInputStream(f));
    } catch (IOException e) {
      tryRenderMessage("File " + f.getAbsolutePath() + " not found!");
      return;
    }
    model.loadImageHelp(image, curLayer, x, y);
    view.addImageToGUI(model.compressImage());
    tryRenderMessage("Image loaded successfully");
  }

  /**
   * This method makes a new project.
   *
   * @param height the height of the project.
   * @param width the width of the project.
   */
  @Override
  public void newProject(int height, int width, int maxValue) {
    model.newProject(height, width, maxValue);
    view.addImageToGUI(model.compressImage());
  }


  /**
   * This method saves the image to a file.
   *
   * @param fileType the type of file it is being saved as.
   */
  public void saveImage(String fileType) throws IOException {
    if (!fileType.equals("ppm") && !fileType.equals("png") && !fileType.equals("jpg")) {
      tryRenderMessage("Invalid file type");
      return;
    }

    if (fileType.equals("ppm")) {
      savePPM();
    } else {
      File f = view.saveFile();
      BufferedImage img = model.compressImage();
      try {
        ImageIO.write(img, fileType, f);
      } catch (IOException e) {
        tryRenderMessage("File " + f.getAbsolutePath() + " not found! / INVALID");
      }
    }
  }

}