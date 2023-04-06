package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

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
import model.PPMImage;
import model.Pixel;
import view.GUIView;

/**
 * Represents the controller for the GUI view.
 */
public class GUIController implements Features {
  private JPanel panel;
  private GUIView view;
  private IImageProcessorModel model;


  /**
   * Represents the default constructor for the GUIController.
   * @param view
   * @param model
   */
  public GUIController(GUIView view,  IImageProcessorModel model) {
    super();
    this.view = view;
    this.model = model;

    this.view.addFeatures(this);
    this.view.display();
  }


  //FIXME: delete this
  public void actionPerformed(ActionEvent e) {
    String nameLayer = "";
    String nameFilter = "";
    switch(e.getActionCommand()) {
      case "Red":
        //FIXME: some input from user to get the name of the layer
        nameFilter = "Red";
        //set the filter of the layer to red
        this.model.setFilter(nameLayer, new RedFilter());
        //show that layer to the user
        break;
      case "Green":
        break;
      case "Blue":
        break;
      case "Exit Button":
        System.exit(0);
        break;
    }
  }

  /**
   * This method should select a filter by utilizing its name.
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
    ImageProcessorModel model;
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
  public void saveImage() {
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
   * @param curLayer the current layer.
   */
  @Override
  public void blueFilter(String curLayer) {

  }

  /**
   * This method applies a brightenIntensity filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void brightenIntensity(String curLayer) {

  }

  /**
   * This method applies a brightenLuma filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void brightenLuma(String curLayer) {

  }

  /**
   * This method applies a brightenValue filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void brightenValue(String curLayer) {

  }

  /**
   * This method applies a darkenIntensity filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void darkenIntensity(String curLayer) {

  }

  /**
   * This method applies a darkenLuma filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void darkenLuma(String curLayer) {

  }

  /**
   * This method applies a darkenValue filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void darkenValue(String curLayer) {

  }

  /**
   * This method applies a green filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void greenFilter(String curLayer) {

  }

  /**
   * This method applies a normal filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void normal(String curLayer) {

  }

  /**
   * This method applies a red filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void redFilter(String curLayer) {
    //FIXME: get the current layer from the user in some way.
    try {
      model.setFilter(curLayer, new RedFilter());
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose an layer.");
    }
  }

  /**
   * This method applies a screen filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void screen(String curLayer) {

  }

  /**
   * This method applies a multiply filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void multiply(String curLayer) {

  }
  /**
   * This method applies a multiply filter to the current layer.
   * @param curLayer the current layer.
   */
  @Override
  public void difference(String curLayer) {

  }

  /**
   * This method adds a blank layer to the project.
   */
  @Override
  public void addLayer() {
    model.addLayer(view.addLayerHelp(), new Normal());
  }

  /**
   * This method adds an image to the layer.
   * @param curLayer the current layer.
   */
  @Override
  public void addImage(String curLayer) {
    Scanner sc;
    int width;
    int height;
    int maxValue;
    Pixel[][] pixels;

    try {
      sc = new Scanner(new FileInputStream(view.addImageToLayer()));
      tryRenderMessage("Image loaded successfully");
    } catch (FileNotFoundException e) {
      tryRenderMessage("File " + view.addImageToLayer().getAbsolutePath() + " not found!");
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
    model.addImage(0,0, new PPMImage(pixels, height, width), model.getLayer(curLayer));
  }

  public void tryRenderMessage(String msg) {
    try {
      this.view.renderMessage(msg);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Message could not be rendered");
    }
  }

}