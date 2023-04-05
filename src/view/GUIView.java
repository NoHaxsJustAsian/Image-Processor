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
import model.Filters.RedFilter;
import model.ILayer;
import model.ImageProcessorModel;


//FIXME: add java doc, add to read me, add to interface.


/**
 * Represents the GUI view for the program.
 */

public class GUIView extends JFrame implements IImageProcessorView, ActionListener {

  private ImageProcessorModel model;
  private GUIController controller;

  //List
  private JList list;
  private DefaultListModel listModel;
  private static final String selectString = "Select";
  private static final String addLayerString = "Add Layer";
  private JButton selectButton;
  private JTextField layerName;
  private JLabel label;
  private JTextField textField;
  private JPopupMenu popupMenu;

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

  //Composite Filters
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




    this.getContentPane().setBackground(Color.WHITE);


    this.label = new JLabel("Image Processor");
    this.add(label);

    this.textField = new JTextField(25);
    this.add(this.textField);


    this.setLayout(new FlowLayout());
    
    RedFilterButton = new JButton("Red");
    RedFilterButton.setActionCommand("Red Button");
    RedFilterButton.setBounds(0,0,0,0);
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


    ExitButton = new JButton("Exit");
    ExitButton.setActionCommand("Exit Button");
    this.add(this.ExitButton);


    popupMenu = new JPopupMenu("Layers");
    JMenuItem menuItemFirst = new JMenuItem("first");
    popupMenu.add(menuItemFirst);

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

    ExitButton.addActionListener(e -> f.exit());
    LoadButton.addActionListener(e -> f.load());
    SaveButton.addActionListener(e -> f.save());

  }


  
  public ListDemo() {

    listModel = new DefaultListModel();


    //Create the list and put it in a scroll pane.
    list = new JList(listModel);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setSelectedIndex(0);
    list.addListSelectionListener(this);
    list.setVisibleRowCount(5);
    JScrollPane listScrollPane = new JScrollPane(list);

    JButton addLayerButton = new JButton(addLayerString);
    HireListener addLayerListener = new addLayerListener(addlayerButton);
    hireButton.setActionCommand(AddLayerString);
    hireButton.addActionListener(hireListener);
    hireButton.setEnabled(false);

    fireButton = new JButton(fireString);
    fireButton.setActionCommand(fireString);
    fireButton.addActionListener(new FireListener());

    employeeName = new JTextField(10);
    employeeName.addActionListener(hireListener);
    employeeName.getDocument().addDocumentListener(hireListener);
    String name = listModel.getElementAt(
                          list.getSelectedIndex()).toString();

    //Create a panel that uses BoxLayout.
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new BoxLayout(buttonPane,
                                       BoxLayout.LINE_AXIS));
    buttonPane.add(fireButton);
    buttonPane.add(Box.createHorizontalStrut(5));
    buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
    buttonPane.add(Box.createHorizontalStrut(5));
    buttonPane.add(employeeName);
    buttonPane.add(hireButton);
    buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

    add(listScrollPane, BorderLayout.CENTER);
    add(buttonPane, BorderLayout.PAGE_END);
}


  class FireListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //This method can be called only if
        //there's a valid selection
        //so go ahead and remove whatever's selected.
        int index = list.getSelectedIndex();
        listModel.remove(index);

        int size = listModel.getSize();

        if (size == 0) { //Nobody's left, disable firing.
            fireButton.setEnabled(false);

        } else { //Select an index.
            if (index == listModel.getSize()) {
                //removed item in last position
                index--;
            }

            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
    }
}

//This listener is shared by the text field and the hire button.
class HireListener implements ActionListener, DocumentListener {
    private boolean alreadyEnabled = false;
    private JButton button;

    public HireListener(JButton button) {
        this.button = button;
    }

    //Required by ActionListener.
    public void actionPerformed(ActionEvent e) {
        String name = employeeName.getText();

        //User didn't type in a unique name...
        if (name.equals("") || alreadyInList(name)) {
            Toolkit.getDefaultToolkit().beep();
            employeeName.requestFocusInWindow();
            employeeName.selectAll();
            return;
        }

        int index = list.getSelectedIndex(); //get selected index
        if (index == -1) { //no selection, so insert at beginning
            index = 0;
        } else {           //add after the selected item
            index++;
        }

        listModel.insertElementAt(employeeName.getText(), index);
        //If we just wanted to add to the end, we'd do this:
        //listModel.addElement(employeeName.getText());

        //Reset the text field.
        employeeName.requestFocusInWindow();
        employeeName.setText("");

        //Select the new item and make it visible.
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
    }

    //This method tests for string equality. You could certainly
    //get more sophisticated about the algorithm.  For example,
    //you might want to ignore white space and capitalization.
    protected boolean alreadyInList(String name) {
        return listModel.contains(name);
    }

    //Required by DocumentListener.
    public void insertUpdate(DocumentEvent e) {
        enableButton();
    }

    //Required by DocumentListener.
    public void removeUpdate(DocumentEvent e) {
        handleEmptyTextField(e);
    }

    //Required by DocumentListener.
    public void changedUpdate(DocumentEvent e) {
        if (!handleEmptyTextField(e)) {
            enableButton();
        }
    }

    private void enableButton() {
        if (!alreadyEnabled) {
            button.setEnabled(true);
        }
    }

    private boolean handleEmptyTextField(DocumentEvent e) {
        if (e.getDocument().getLength() <= 0) {
            button.setEnabled(false);
            alreadyEnabled = false;
            return true;
        }
        return false;
    }
}

//This method is required by ListSelectionListener.
public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting() == false) {

        if (list.getSelectedIndex() == -1) {
        //No selection, disable fire button.
            fireButton.setEnabled(false);

        } else {
        //Selection, enable the fire button.
            fireButton.setEnabled(true);
        }
    }
}

/**
 * Create the GUI and show it.  For thread safety,
 * this method should be invoked from the
 * event-dispatching thread.
 */
private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("ListDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new ListDemo();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
}


}



