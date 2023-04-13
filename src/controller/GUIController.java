package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.IImageProcessorModel;
import model.ILayer;
import model.IPixel;
import model.ImageProcessorModel;
import model.Layer;
import model.PPMImage;
import model.Pixel;
import model.filters.BlueFilter;
import model.filters.BrightenIntensity;
import model.filters.BrightenLuma;
import model.filters.BrightenValue;
import model.filters.DarkenIntensity;
import model.filters.DarkenLuma;
import model.filters.DarkenValue;
import model.filters.Difference;
import model.filters.GreenFilter;
import model.filters.IFilter;
import model.filters.Multiply;
import model.filters.Normal;
import model.filters.RedFilter;
import model.filters.Screen;
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
   * This method should select a filter by utilizing its name.
   *
   * @param name the name of the filter.
   */
  private IFilter filterHelp(String name) {
    switch (name) {
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


  /**
   * This method should load a project and set the model to the project.
   */
  public void loadProject() {
    Scanner sc;
    int width;
    int height;
    int maxRGB;
    IImageProcessorModel model;
    IFilter filter;
    List<ILayer> orderLayers = new ArrayList<ILayer>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();
    IPixel[][] pixels;

    try {
      sc = new Scanner(new FileInputStream(view.loadProject()));
    } catch (FileNotFoundException e) {
      this.tryRenderMessage("File " + view.loadProject().getAbsolutePath() + " not found!");
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
    width = sc.nextInt();
    height = sc.nextInt();
    maxRGB = sc.nextInt();
    while (sc.hasNext()) {
      String name = sc.next();
      try {
        filter = filterHelp(sc.next()); //FIXME: fix naming scheme of filters
      } catch (IllegalArgumentException e) {
        this.tryRenderMessage("Invalid filter name");
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
  }

  /**
   * This method saves a project to a file.
   */
  @Override
  public void saveProject() {
    File file = view.saveFile();

    IPixel[][] finalPixels = model.saveCanvas();

    PrintWriter writer;
    try {
      writer = new PrintWriter(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    for (int i = 0; i < model.getHeight(); i++) {
      for (int j = 0; j < model.getWidth(); j++) {
        writer.println(finalPixels[i][j].getRed()
                + " " + finalPixels[i][j].getGreen()
                + " " + finalPixels[i][j].getBlue());
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
    IPixel[][] finalPixels = model.saveCanvas();

    PrintWriter writer;
    try {
      writer = new PrintWriter(f);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.println("P3");
    writer.println(model.getWidth() + " " + model.getHeight());
    writer.println(model.getMaxValue());
    for (int i = 0; i < model.getHeight(); i++) {
      for (int j = 0; j < model.getWidth(); j++) {
        writer.println(finalPixels[i][j].getRed()
                + " " + finalPixels[i][j].getGreen()
                + " " + finalPixels[i][j].getBlue());
      }
    }
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
      model.setFilter(curLayer, new BlueFilter());
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
      model.setFilter(curLayer, new BrightenIntensity());
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
      model.setFilter(curLayer, new BrightenLuma());
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
      model.setFilter(curLayer, new BrightenValue());
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
      model.setFilter(curLayer, new DarkenIntensity());
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
      model.setFilter(curLayer, new DarkenLuma());
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
      model.setFilter(curLayer, new DarkenValue());
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
      model.setFilter(curLayer, new GreenFilter());
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
      model.setFilter(curLayer, new Normal());
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
      model.setFilter(curLayer, new RedFilter());
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
      model.setFilter(curLayer, new Screen());
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
      model.setFilter(curLayer, new Multiply());
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
      model.setFilter(curLayer, new Difference());
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
    model.addLayer(name, new Normal());
  }

  /**
   * This method adds an image to the layer.
   *
   * @param curLayer the current layer.
   */
  @Override
  public void addPPM(String curLayer) {
    Scanner sc;
    int width;
    int height;
    int maxValue;
    Pixel[][] pixels;
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
    width = sc.nextInt();
    System.out.println("Width of image: " + width);
    height = sc.nextInt();
    System.out.println("Height of image: " + height);
    maxValue = sc.nextInt();
    pixels = new Pixel[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels[i][j] = new Pixel(r, g, b, 255);
      }
    }
    model.addImage(0, 0, new PPMImage(pixels, height, width), model.getLayer(curLayer));
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
  public void addImage(String curLayer) {
    BufferedImage image;
    if (view.addImageToLayer().getAbsolutePath().endsWith(".ppm")) {
      addPPM(curLayer);
      return;
    }
    try {
      image = ImageIO.read(new FileInputStream(view.addImageToLayer()));
    } catch (IOException e) {
      tryRenderMessage("File " + view.addImageToLayer().getAbsolutePath() + " not found!");
      return;
    }
    int width = image.getWidth();
    int height = image.getHeight();
    Pixel[][] pixels = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int rgb = image.getRGB(j, i);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb & 0xFF);
        pixels[i][j] = new Pixel(r, g, b, 255);
      }
    }
    model.addImage(0, 0, new PPMImage(pixels, height, width), model.getLayer(curLayer));
    tryRenderMessage("Image loaded successfully");
  }

  /**
   * This method makes a new project.
   *
   * @param height
   * @param width
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
        tryRenderMessage("File " + view.saveFile().getAbsolutePath() + " not found! / INVALID");
      }
    }
  }

}