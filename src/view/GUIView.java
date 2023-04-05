package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Features;
import controller.GUIController;
import model.Filters.IFilter;
import model.ILayer;
import model.ImageProcessorModel;


//FIXME: add java doc, add to read me, add to interface.


/**
 * Represents the GUI view for the program.
 */

public class GUIView extends JFrame implements IImageProcessorView {

  private ImageProcessorModel model;
  private GUIController controller;


  //Buttons Sections
  private JPanel buttonPane;

  //Project Buttons
  private JButton LoadButton;
  private JButton SaveProjectButton;
  private JButton SaveImageButton;
  private JButton AddImageButton;

  
  //Filter Buttons
  private JButton Normal;
  public JButton RedFilterButton, GreenFilterButton, BlueFilterButton;
  private JButton BrightenIntensityButton, BrightenLumaButton,
          BrightenValueButton, DarkenIntensityButton, DarkenLumaButton,
          DarkenValueButton;
  private JButton MultiplyButton, DifferenceButton, ScreenButton;




  //Layer Section
  private JPanel layerPane;
  private JButton AddLayerButton;
  private JButton SelectLayerButton;
  private JComboBox<ILayer> layerList;




  //Buffered Image Section
  private JPanel imagePane;
  private JScrollBar verticalBar;
  private JScrollBar horizontalBar;



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


    //FIXME: add error box
    JPanel errorBox = new JPanel();

    


    //BUTTONS
    RedFilterButton = new JButton("Red");
    RedFilterButton.setActionCommand("Red Button");
    this.add(this.RedFilterButton);

    GreenFilterButton = new JButton("Green");
    GreenFilterButton.setActionCommand("Green Button");
    this.add(this.GreenFilterButton);

    BlueFilterButton = new JButton("Blue");
    BlueFilterButton.setActionCommand("Blue Button");
    this.add(this.BlueFilterButton);

    BrightenIntensityButton = new JButton("Brighten Intensity");
    BrightenIntensityButton.setActionCommand("Brighten Intensity Button");
    this.add(this.BrightenIntensityButton);

    BrightenLumaButton = new JButton("Brighten Luma");
    BrightenLumaButton.setActionCommand("Brighten Luma Button");
    this.add(this.BrightenLumaButton);

    BrightenValueButton = new JButton("Brighten Value");
    BrightenValueButton.setActionCommand("Brighten Value Button");
    this.add(this.BrightenValueButton);

    DarkenIntensityButton = new JButton("Darken Intensity");
    DarkenIntensityButton.setActionCommand("Darken Intensity Button");
    this.add(this.DarkenIntensityButton);

    DarkenLumaButton = new JButton("Darken Luma");
    DarkenLumaButton.setActionCommand("Darken Luma Button");
    this.add(this.DarkenLumaButton);

    DarkenValueButton = new JButton("Darken Value");
    DarkenValueButton.setActionCommand("Darken Value Button");
    this.add(this.DarkenValueButton);

    MultiplyButton = new JButton("Multiply");
    MultiplyButton.setActionCommand("Multiply Button");
    this.add(this.MultiplyButton);

    DifferenceButton = new JButton("Difference");
    DifferenceButton.setActionCommand("Difference Button");
    this.add(this.DifferenceButton);

    ScreenButton = new JButton("Screen");
    ScreenButton.setActionCommand("Screen Button");
    this.add(this.ScreenButton);

    LoadButton = new JButton("Load");
    LoadButton.setActionCommand("Load Project Button");
    this.add(this.LoadButton);

    AddLayerButton = new JButton("Add Layer");
    LoadButton.setActionCommand("Add Layer Button");
    this.add(this.AddLayerButton);

    ExitButton = new JButton("Exit");
    ExitButton.setActionCommand("Exit Button");
    this.add(this.ExitButton);


    //Pop up menu for Layers
    popupMenu = new JPopupMenu("Layers");
    JMenuItem menuItemFirst = new JMenuItem("first");
    popupMenu.add(menuItemFirst);



    //IMAGE PANEL
    imagePane = new JPanel();
    imagePane.setBorder(BorderFactory.createTitledBorder("Composite Image"));
    imagePane.setLayout(new GridLayout(2, 2));
    imagePane.add(new JLabel("Composite Image"));
    imagePane.add();


    //BUTTON PANEL
    buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(FlowLayout.LEADING));
    buttonPane.add(RedFilterButton);
    buttonPane.add(GreenFilterButton);
    buttonPane.add(BlueFilterButton);
    buttonPane.add(BrightenIntensityButton);
    buttonPane.add(BrightenLumaButton);
    buttonPane.add(BrightenValueButton);
    buttonPane.add(DarkenIntensityButton);
    buttonPane.add(DarkenLumaButton);
    buttonPane.add(DarkenValueButton);
    buttonPane.add(MultiplyButton);
    buttonPane.add(DifferenceButton);
    buttonPane.add(ScreenButton);
    buttonPane.add(LoadButton);
    buttonPane.add(SaveImageButton);
    buttonPane.add(SaveProjectButton);
    buttonPane.add(AddImageButton);


    //LAYER PANEL
    layerPane = new JPanel();


    this.pack();
    this.setVisible(true);
  }

  public JMenuItem addPopupMenuItem(ILayer layer) {
    JMenuItem menuItem = new JMenuItem(layer.getName());
    popupMenu.add(menuItem);
    return menuItem;
  }


  /**
   * Refreshes the view.
   */
  public void refresh() {
    this.repaint();
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

  public File saveProject() {
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
   *
   * @param img represents the given image.
   */
  public void addImageToGUI(Image img) {

  }


  /**
   * Renders a message to the GUIView.
   *
   * @param message
   * @throws IOException
   */
  @Override
  public void renderMessage(String message) throws IOException {
    //FIXME: make this just make pop ups
  }

  /**
   * Renders a state to the GUIview.
   *
   * @param
   * @throws IOException
   */
  @Override
  public void renderState() throws IOException {

  }


  /**
   * Set the listener for any actions
   *
   * @param listener
   */
  public void setListener(ActionListener listener) {
    RedFilterButton.addActionListener(listener);
  }

  /**
   * Displays the view.
   */
  public void display() {
    setVisible(true);
  }


  public void addFeatures(Features f) {
    RedFilterButton.addActionListener(e -> f.redFilter());
    GreenFilterButton.addActionListener(e -> f.greenFilter());
    BlueFilterButton.addActionListener(e -> f.blueFilter());
    BrightenIntensityButton.addActionListener(e -> f.brightenIntensity());
    BrightenLumaButton.addActionListener(e -> f.brightenLuma());
    BrightenValueButton.addActionListener(e -> f.brightenValue());
    DarkenIntensityButton.addActionListener(e -> f.darkenIntensity());
    DarkenLumaButton.addActionListener(e -> f.darkenLuma());
    DarkenValueButton.addActionListener(e -> f.darkenValue());
    MultiplyButton.addActionListener(e -> f.multiply());
    DifferenceButton.addActionListener(e -> f.difference());
    ScreenButton.addActionListener(e -> f.screen());
    Normal.addActionListener(e -> f.normal());

    SaveProjectButton.addActionListener(e -> f.saveProject());
    LoadButton.addActionListener(e -> f.loadProject());
    SaveImageButton.addActionListener(e -> f.saveImage());

    AddLayerButton.addActionListener(e -> f.addLayer());
    AddImageButton.addActionListener(e -> f.addImage());

  }

}