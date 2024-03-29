package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Features;


/**
 * Represents the GUI view for the program. This displays the JFrame of the Program including
 * the buttons, the image, and the layers.
 * This class also implements the IImageProcessorView interface.
 */
public class GUIView extends JFrame implements IImageProcessorView {

  private int height = 0;
  private int width = 0;
  private int maxValue = 0;

  private String curLayer = "";


  //Buttons Sections

  //private JPanel buttonPane;

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
  private JButton addLayerButton;

  private JButton selectLayerButton;
  private JComboBox<String> layerList;
  ArrayList<String> layerNames = new ArrayList<String>();


  //Buffered Image Section
  private JLabel imageLabel;


  //MISCELLANEOUS
  private JFileChooser fileChooser;
  private JComboBox<String> formats;


  /**
   * Constructor for the GUIView. Sets up the JFrame and the panels and the buttons.
   */
  public GUIView() {
    super("Image Processor");
    imageLabel = new JLabel();

    //FRAME
    this.setSize(1000, 600);
    this.setTitle("Image Processor");
    this.setLocation(200, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(new FlowLayout());
    this.getContentPane().setBackground(Color.WHITE);

    //PANELS LAYOUT ON FRAME
    this.setLayout(new BorderLayout());
    JPanel imagePane = new JPanel();
    this.add(imagePane, BorderLayout.WEST);
    imagePane.setBorder(BorderFactory.createTitledBorder("Buffered Image"));
    imagePane.setPreferredSize(new Dimension(1000, 600));
    JPanel buttonPane = new JPanel();
    imagePane.add(imageLabel);
    this.add(buttonPane, BorderLayout.EAST);
    buttonPane.setBorder(BorderFactory.createTitledBorder("Buttons"));
    buttonPane.setPreferredSize(new Dimension(250, 250));
    JPanel layerPane = new JPanel();
    this.add(layerPane, BorderLayout.SOUTH);
    layerPane.setBorder(BorderFactory.createTitledBorder("Layers"));
    layerPane.setPreferredSize(new Dimension(250, 250));


    JPanel selectedLayerBox = new JPanel();
    selectedLayerBox.setBorder(BorderFactory.createTitledBorder("Selected Image"));
    selectedLayerBox.setLayout(new GridLayout(2, 2));
    this.add(selectedLayerBox);


    JPanel compositeImageBox = new JPanel();
    compositeImageBox.setBorder(BorderFactory.createTitledBorder("Composite Image"));
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
    this.add(selectLayerButton);


    //COMBO BOX FOR LAYERS
    String[] layerNamesArray = layerNames.toArray(new String[layerNames.size()]);
    layerList = new JComboBox<String>(layerNamesArray);
    layerList.setActionCommand("Layer List");


    //COMBO BOX FOR FORMATS
    String[] formats = {"ppm", "jpg", "png"};
    this.formats = new JComboBox<String>(formats);
    this.formats.setSelectedIndex(0);


    //IMAGE PANEL
    imageLabel = new JLabel();
    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
    imagePane.add(imageScrollPane);
    imagePane.setBorder(BorderFactory.createTitledBorder("Composite Image"));
    imagePane.setLayout(new FlowLayout(FlowLayout.LEADING));


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
    buttonPane.add(addImageButton);
    buttonPane.add(saveProjectButton);
    buttonPane.add(saveImageButton);
    buttonPane.add(newProjectButton);
    buttonPane.add(this.formats);


    //LAYER PANEL
    layerPane.add(layerList);
    layerPane.add(addLayerButton);
    layerPane.add(selectLayerButton);
    this.add(imagePane);


    this.pack();
    this.setVisible(true);
  }


  /**
   * Refreshes the view.
   */
  public void refresh() {
    this.repaint();
    this.validate();
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
    final JFileChooser fc = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image",
            "ppm", "jpg", "png");
    fc.setFileFilter(filter);
    int response = fc.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      f = fc.getSelectedFile();
    }
    curLayer = layerList.getSelectedItem().toString();

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
    String name = JOptionPane.showInputDialog("Enter a name for the layer");
    layerNames.add(name);
    layerList.addItem(name);
    return name;
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
    });
    selectLayerButton.addActionListener(e -> {
      curLayer = layerList.getSelectedItem().toString();
    });
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

    addImageButton.addActionListener(e -> {
      int x = Integer.parseInt(JOptionPane.showInputDialog("Enter x displacement"));
      int y = Integer.parseInt(JOptionPane.showInputDialog("Enter y displacement"));
      f.addImage(curLayer, x, y);
    });
  }

}