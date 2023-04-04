package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

//FIXME: add java doc, add to read me, add to interface.

public class GUIView extends JFrame implements IImageProcessorView {

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
  private JButton RedFilterButton;
  private JButton GreenFilterButton;
  private JButton BlueFilterButton;


  //Brighten/Darken Filters
  private JButton BrightenIntensityButton;
  private JButton BrightenLumaButton;
  private JButton BrightenValueButton;
  private JButton DarkenIntensityButton;
  private JButton DarkenLumaButton;
  private JButton DarkenValueButton;



  public GUIView() {
    super("Image Processor");

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


    this.setSize(500, 500);
    this.setTitle("Image Processor");
    this.setLocation(200, 200);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setMinimumSize(new Dimension(500, 500));



    this.getContentPane().setBackground(Color.WHITE);


    this.label = new JLabel("Image Processor");
    this.add(label);

    this.textField = new JTextField(25);
    this.add(this.textField);


    RedFilterButton = new JButton("Red");
    RedFilterButton.setActionCommand("Red Button");
    this.add(RedFilterButton);



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
  public void addImageToView(Image img) {

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
   * @param message
   * @throws IOException
   */
  @Override
  public void renderState() throws IOException {

  }



}
