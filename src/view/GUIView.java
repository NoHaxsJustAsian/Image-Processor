package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.image.BufferedImage;
import java.io.File;
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
import model.ILayer;
import model.ImageProcessorModel;


//FIXME: add java doc, add to read me, add to interface.


/**
 * Represents the GUI view for the program. This displays the JFrame of the Program including
 * the buttons, the image, and the layers.
 * This class also implements the IImageProcessorView interface.
 */
public class GUIView extends JFrame implements IImageProcessorView {

  private ImageProcessorModel model;
  private GUIController controller;

  private String curLayer;


  //Buttons Sections

  private JPanel buttonPane;

  //Project Buttons
  private JButton loadButton;
  private JButton saveProjectButton;
  private JButton saveImageButton;
  private JButton addImageButton;
  private JButton selectFile;


  //Filter Buttons
  private JButton normal;
  public JButton redFilterButton;
  public JButton greenFilterButton, blueFilterButton;
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


  /**
   * Constructor for the GUIView. Sets up the JFrame and the panels and the buttons.
   *
   * @param model
   */
  public GUIView(ImageProcessorModel model) {
    super("Image Processor");

    this.model = model;
    this.controller = new GUIController(this, model);

    //FRAME
    this.setSize(500, 500);
    this.setTitle("Image Processor");
    this.setLocation(200, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(new FlowLayout());
    this.getContentPane().setBackground(Color.WHITE);

    //PANELS LAYOUT ON FRAME
    this.setLayout(new BorderLayout());
    this.add(imagePane, BorderLayout.WEST);
    imagePane.setBorder(BorderFactory.createTitledBorder("Buffered Image"));
    imagePane.setPreferredSize(new Dimension(250, 500));
    this.add(buttonPane, BorderLayout.EAST);
    buttonPane.setBorder(BorderFactory.createTitledBorder("Buttons"));
    buttonPane.setPreferredSize(new Dimension(250, 250));
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


//    //Pop up menu for Layers
//    popupMenu = new JPopupMenu("Layers");
//    JMenuItem menuItemFirst = new JMenuItem("first");
//    popupMenu.add(menuItemFirst);


    //COMBO BOX FOR LAYERS
    ArrayList<String> layerNames = new ArrayList<String>();
    for (ILayer layer : model.getLayers()) {
      layerNames.add(layer.getName());
    }
    String[] layerNamesArray = layerNames.toArray(new String[layerNames.size()]);
    layerList = new JComboBox<String>(layerNamesArray);
    layerList.setActionCommand("Layer List");
    curLayer = layerList.getSelectedItem().toString();


    //IMAGE PANEL
    imagePane = new JPanel();
    imageScrollPane = new JScrollPane(imageLabel);
    imagePane.add(imageScrollPane);
    imagePane.setBorder(BorderFactory.createTitledBorder("Composite Image"));
    imagePane.setLayout(new FlowLayout(FlowLayout.LEADING));
    imagePane.add(new JLabel("Composite Image"));
    imagePane.add(imageScrollPane);
    imageLabel.setIcon(new ImageIcon(model.compressImage()));


    //BUTTON PANEL
    buttonPane = new JPanel();
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


    //LAYER PANEL
    layerPane = new JPanel();
    layerPane.add(layerList);


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
            "ppm");
    fc.setFileFilter(filter);
    int response = fc.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      f = fc.getSelectedFile();
    }
    return f;
  }


  /**
   * Adds this image to the view.
   */
  public void addImageToGUI(BufferedImage bufferedImage) {
    imagePane.add(new JLabel(new ImageIcon(bufferedImage)));
    this.pack();
    this.setVisible(true);
    refresh();
  }


  /**
   * Renders a message to the GUIView.
   */
  @Override
  public void renderMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Message",
            JOptionPane.PLAIN_MESSAGE);
  }


  /**
   * Displays the view.
   */
  public void display() {
    setVisible(true);
  }

  /**
   * Gets name of layer from user.
   */
  public String addLayerHelp() {
    return JOptionPane.showInputDialog("Enter a name for the layer");
  }

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

    saveProjectButton.addActionListener(e -> f.saveProject());
    loadButton.addActionListener(e -> f.loadProject());
    saveImageButton.addActionListener(e -> f.saveImage());

    addLayerButton.addActionListener(e -> {
      f.addLayer(this.addLayerHelp());

    });
    addImageButton.addActionListener(e -> f.addImage(curLayer));

  }

}