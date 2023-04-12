package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


import controller.Features;
import controller.GUIController;
import model.IImageProcessorModel;
import model.ILayer;



/**
 * Represents the GUI view for the program. This displays the JFrame of the Program including
 * the buttons, the image, and the layers.
 * This class also implements the IImageProcessorView interface.
 */
public class GUIView extends JFrame implements IImageProcessorView {

  private int height = 0;
  private int width = 0;
  private int maxValue = 0;

  private IImageProcessorModel model;
  private GUIController controller;

  private String curLayer = "";


  //Buttons Sections

  private JPanel buttonPane;

  //Project Buttons
  private JButton loadButton;
  private JButton saveProjectButton;
  private JButton saveImageButton;
  private JButton addImageButton;
  private JButton newProjectButton;


  //Filter Buttons
  private JButton normal;
  private JButton redFilterButton;
  private JButton greenFilterButton;
  private JButton blueFilterButton;
  private JButton brightenIntensityButton;
  private JButton brightenLumaButton;
  private JButton brightenValueButton;
  private JButton darkenIntensityButton;
  private JButton darkenLumaButton;
  private JButton darkenValueButton;
  private JButton multiplyButton;
  private JButton differenceButton;
  private JButton screenButton;




  //Layer Section
  private JPanel layerPane;
  private JButton addLayerButton;
  private JButton selectLayerButton;
  private JComboBox<String> layerList;




  //Buffered Image Section
  private JPanel imagePane;
  private JScrollPane imageScrollPane;
  private JLabel imageLabel;


  //MISCELLANEOUS
  private JFileChooser fileChooser;
  private JComboBox<String> formats;


  /**
   * Constructor for the GUIView. Sets up the JFrame and the panels and the buttons.
   * @param model
   */
  public GUIView(IImageProcessorModel model) {
    super("Image Processor");
    this.model = model;

    imageLabel = new JLabel();
    //FRAME
    this.setSize(800, 800);
    this.setTitle("Image Processor");
    this.setLocation(200, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(new FlowLayout());
    this.getContentPane().setBackground(Color.WHITE);

    //PANELS LAYOUT ON FRAME
    this.setLayout(new BorderLayout());
    imagePane = new JPanel();
    this.add(imagePane, BorderLayout.WEST);
    imagePane.setBorder(BorderFactory.createTitledBorder("Buffered Image"));
    imagePane.setPreferredSize(new Dimension(250, 500));
    buttonPane = new JPanel();
    imagePane.add(imageLabel);
    this.add(buttonPane, BorderLayout.EAST);
    buttonPane.setBorder(BorderFactory.createTitledBorder("Buttons"));
    buttonPane.setPreferredSize(new Dimension(250, 250));
    layerPane = new JPanel();
    this.add(layerPane, BorderLayout.SOUTH);
    layerPane.setBorder(BorderFactory.createTitledBorder("Layers"));
    layerPane.setPreferredSize(new Dimension(250, 250));



    JPanel selectedLayerBox = new JPanel();
    selectedLayerBox.setBorder(BorderFactory.createTitledBorder("Selected Image"));
    //FIXME: fix grid layout for selected image
    selectedLayerBox.setLayout(new GridLayout(2, 2));
    this.add(selectedLayerBox);


    JPanel compositeImageBox = new JPanel();
    compositeImageBox.setBorder(BorderFactory.createTitledBorder("Composite Image"));
    //FIXME: fix grid layout for composite image
    compositeImageBox.setLayout(new GridLayout(2, 2));
    this.add(compositeImageBox);



    //BUTTONS
    redFilterButton = new JButton("Red");
    redFilterButton.setActionCommand("Red Button");
    this.add(this.redFilterButton);

    greenFilterButton = new JButton("Green");
    greenFilterButton.setActionCommand("Green Button");
    this.add(this.greenFilterButton);

    blueFilterButton = new JButton("Blue");
    blueFilterButton.setActionCommand("Blue Button");
    this.add(this.blueFilterButton);

    brightenIntensityButton = new JButton("Brighten Intensity");
    brightenIntensityButton.setActionCommand("Brighten Intensity Button");
    this.add(this.brightenIntensityButton);

    brightenLumaButton = new JButton("Brighten Luma");
    brightenLumaButton.setActionCommand("Brighten Luma Button");
    this.add(this.brightenLumaButton);

    brightenValueButton = new JButton("Brighten Value");
    brightenValueButton.setActionCommand("Brighten Value Button");
    this.add(this.brightenValueButton);

    darkenIntensityButton = new JButton("Darken Intensity");
    darkenIntensityButton.setActionCommand("Darken Intensity Button");
    this.add(this.darkenIntensityButton);

    darkenLumaButton = new JButton("Darken Luma");
    darkenLumaButton.setActionCommand("Darken Luma Button");
    this.add(this.darkenLumaButton);

    darkenValueButton = new JButton("Darken Value");
    darkenValueButton.setActionCommand("Darken Value Button");
    this.add(this.darkenValueButton);

    multiplyButton = new JButton("Multiply");
    multiplyButton.setActionCommand("Multiply Button");
    this.add(this.multiplyButton);

    differenceButton = new JButton("Difference");
    differenceButton.setActionCommand("Difference Button");
    this.add(this.differenceButton);

    screenButton = new JButton("Screen");
    screenButton.setActionCommand("Screen Button");
    this.add(this.screenButton);

    normal = new JButton("Normal");
    normal.setActionCommand("Normal Button");
    this.add(this.normal);

    newProjectButton = new JButton("New Project");
    newProjectButton.setActionCommand("New Project Button");
    this.add(this.newProjectButton);

    loadButton = new JButton("Load");
    loadButton.setActionCommand("Load Project Button");
    this.add(this.loadButton);

    addLayerButton = new JButton("Add Layer");
    loadButton.setActionCommand("Add Layer Button");
    this.add(this.addLayerButton);

    saveProjectButton = new JButton("Save Project");
    saveProjectButton.setActionCommand("Save Project Button");
    this.add(this.saveProjectButton);

    saveImageButton = new JButton("Save Image");
    saveImageButton.setActionCommand("Save Image Button");
    this.add(this.saveImageButton);

    addImageButton = new JButton("Add Image");
    addImageButton.setActionCommand("Add Image Button");
    this.add(this.addImageButton);

    selectLayerButton = new JButton("Select Layer");
    selectLayerButton.setActionCommand("Select Layer Button");
    this.add(this.selectLayerButton);



    //COMBO BOX FOR LAYERS
    ArrayList<String> layerNames = new ArrayList<String>();
    for (ILayer layer : model.getLayers()) {
      layerNames.add(layer.getName());
    }
    String[] layerNamesArray = layerNames.toArray(new String[layerNames.size()]);
    layerList = new JComboBox<String>(layerNamesArray);
    layerList.setActionCommand("Layer List");
    curLayer = layerList.getSelectedItem().toString();


    //COMBO BOX FOR FORMATS
    String[] formats = {"ppm", "jpg", "png"};
    this.formats = new JComboBox<String>(formats);
    this.formats.setSelectedIndex(0);



    //IMAGE PANEL
    imageScrollPane = new JScrollPane(imageLabel);
    imagePane.add(imageScrollPane);
    imagePane.setBorder(BorderFactory.createTitledBorder("Composite Image"));
    imagePane.setLayout(new FlowLayout(FlowLayout.LEADING));
    imagePane.add(imageScrollPane);
    imageLabel = new JLabel();
    imageLabel.setIcon(new ImageIcon(model.compressImage()));



    //BUTTON PANEL
    buttonPane.setLayout(new FlowLayout(FlowLayout.LEADING));
    buttonPane.add(redFilterButton);
    buttonPane.add(greenFilterButton);
    buttonPane.add(blueFilterButton);
    buttonPane.add(brightenIntensityButton);
    buttonPane.add(brightenLumaButton);
    buttonPane.add(brightenValueButton);
    buttonPane.add(darkenIntensityButton);
    buttonPane.add(darkenLumaButton);
    buttonPane.add(darkenValueButton);
    buttonPane.add(multiplyButton);
    buttonPane.add(differenceButton);
    buttonPane.add(screenButton);
    buttonPane.add(loadButton);
    buttonPane.add(saveImageButton);
    buttonPane.add(saveProjectButton);
    buttonPane.add(addImageButton);
    buttonPane.add(newProjectButton);


    //LAYER PANEL
    layerPane.add(layerList);
    layerPane.add(this.formats);
    layerPane.add(addLayerButton);
    layerPane.add(selectLayerButton);


    this.pack();
    this.setVisible(true);
  }


  /**
   * Refreshes the view.
   */
  public void refresh() {
    this.repaint();
    imageLabel.setIcon(new ImageIcon(model.compressImage()));
  }


  /**
   * Creates a file selection for loading a project.
   * File can only be loaded if it has a .collage extension.
   */
  public File loadProject() {
    File f = null;
    final JFileChooser fc = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Collage",
            "collage");
    fc.setFileFilter(filter);
    int response = fc.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      f = fc.getSelectedFile();
    }
    refresh();
    return f;
  }

  /**
   * Saves a file, either a project or composite image helper..
   */
  public File saveFile() {
    File f = null;
    final JFileChooser saver = new JFileChooser(".");
    int ret = saver.showSaveDialog(null);
    if (ret == JFileChooser.APPROVE_OPTION) {
      f = saver.getSelectedFile();
    }
    return f;
  }

  /**
   * Adds an image to selected layer.
   */
  public File addImageToLayer() {
    File f = null;
    //FIXME: add a function to add this to a specific layer.
    final JFileChooser fc = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image",
            "ppm", "jpg", "png");
    fc.setFileFilter(filter);
    int response = fc.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      f = fc.getSelectedFile();
    }
    refresh();
    return f;
  }


  /**
   * Adds this image to the view.
   */
  public void addImageToGUI(BufferedImage bufferedImage) {
    imageLabel.setIcon(new ImageIcon(bufferedImage));
    this.refresh();
  }


  /**
   * Renders a message to the GUIView.
   */
  @Override
  public void renderMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Message",
            JOptionPane.PLAIN_MESSAGE);
    refresh();
  }


  /**
   * Displays the view.
   */
  public void display() {
    setVisible(true);
    refresh();
  }


  private String addLayerHelp() {
    return JOptionPane.showInputDialog("Enter a name for the layer");
  }


  private void newProjectHelp() {
    this.height = Integer.parseInt(JOptionPane.showInputDialog("Enter height"));
    this.width = Integer.parseInt(JOptionPane.showInputDialog("Enter width"));
    this.maxValue = Integer.parseInt(JOptionPane.showInputDialog("Enter maxValue"));
  }

  /**
   * Adds features to the buttons, connecting the view to the controller.
   */
  public void addFeatures(Features f) {
    redFilterButton.addActionListener(e -> f.redFilter(curLayer));
    greenFilterButton.addActionListener(e -> f.greenFilter(curLayer));
    blueFilterButton.addActionListener(e -> f.blueFilter(curLayer));
    brightenIntensityButton.addActionListener(e -> f.brightenIntensity(curLayer));
    brightenLumaButton.addActionListener(e -> f.brightenLuma(curLayer));
    brightenValueButton.addActionListener(e -> f.brightenValue(curLayer));
    darkenIntensityButton.addActionListener(e -> f.darkenIntensity(curLayer));
    darkenLumaButton.addActionListener(e -> f.darkenLuma(curLayer));
    darkenValueButton.addActionListener(e -> f.darkenValue(curLayer));
    multiplyButton.addActionListener(e -> f.multiply(curLayer));
    differenceButton.addActionListener(e -> f.difference(curLayer));
    screenButton.addActionListener(e -> f.screen(curLayer));
    normal.addActionListener(e -> f.normal(curLayer));
    newProjectButton.addActionListener(e -> {
      newProjectHelp();
      f.newProject(height, width, maxValue);
    }
    );

    saveProjectButton.addActionListener(e -> f.saveProject());
    loadButton.addActionListener(e -> f.loadProject());
    saveImageButton.addActionListener(e -> {
      try {
        f.saveImage((String) formats.getSelectedItem());
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    addLayerButton.addActionListener(e -> {
      f.addLayer(this.addLayerHelp());
    });

    addImageButton.addActionListener(e -> f.addImage(curLayer));
  }

}