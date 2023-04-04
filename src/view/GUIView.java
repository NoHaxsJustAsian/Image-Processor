package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.GUIController;
import model.Filters.IFilter;
import model.ImageProcessorModel;

import static java.awt.SystemColor.control;

//FIXME: add java doc, add to read me, add to interface.


public class GUIView extends JFrame implements IImageProcessorView, ActionListener {

  private ImageProcessorModel model;
  private GUIController controller;


  private JLabel label;
  private JTextField textField;


  //Buttons
  private JButton LoadButton;
  private JButton SaveButton;
  private JButton ExitButton;
  private JButton AddImageButton;


  //Layer Buttons
  private JButton AddLayerButton;
  private JButton RemoveLayerButton;
  //FIXME: make a button to select a layer...


  //Color Filters
  public JButton RedFilterButton, GreenFilterButton, BlueFilterButton;


  //Brighten/Darken Filters
  private JButton BrightenIntensityButton, BrightenLumaButton,
          BrightenValueButton, DarkenIntensityButton, DarkenLumaButton,
          DarkenValueButton;

  //Composite FIlters
  private JButton MultiplyButton, DifferenceButton, ScreenButton;




  public GUIView(ImageProcessorModel model) {
    super("Image Processor");

    this.model = model;
    this.controller = new GUIController(this, model);

    JPanel buttonBox = new JPanel();
    JPanel layerBox = new JPanel();

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


    this.setSize(500, 500);
    this.setTitle("Image Processor");
    this.setLocation(200, 200);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setResizable(false);
    //this.setMinimumSize(new Dimension(500, 500));


    this.setLayout(new FlowLayout());


    this.getContentPane().setBackground(Color.WHITE);


    this.label = new JLabel("Image Processor");
    this.add(label);

    this.textField = new JTextField(25);
    this.add(this.textField);


    RedFilterButton = new JButton("Red");
    RedFilterButton.setActionCommand("Red Button");
    RedFilterButton.addActionListener(e -> controller.redFilter());
    this.add(this.RedFilterButton);


    ExitButton = new JButton("Exit");
    ExitButton.setActionCommand("Exit Button");
    ExitButton.addActionListener(controller);
    this.add(this.ExitButton);





    this.pack();
    this.setVisible(true);

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
   * Renders a message to the GUIview.
   * @param message
   * @throws IOException
   */
  @Override
  public void renderMessage(String message) throws IOException {

  }
  /**
   * Renders a state to the GUIview.
   * @param
   * @throws IOException
   */
  @Override
  public void renderState() throws IOException {

  }

  @Override
  public void setRedButtonOutput() {

  }

  @Override
  public IFilter getInputButton() {
    return null;
  }

  @Override
  public void clearFilter() {

  }


  /**
   * Set the listener for any actions
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

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
