package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * Represents our Swing GUI view.
 */
public class GUIView extends JFrame implements IImageProcessorView {

  JScrollPane imageScrollPane;
  JPanel base;
  JPanel box;
  private JTextField increment;
  private JLabel imageLabel;
  private Image curImg;
  private JButton exitButton;
  private JButton fileOpenButton;
  private JButton fileSaveButton;
  private JButton vFlipButton;
  private JButton hFlipButton;
  private JButton blueButton;
  private JButton greenButton;
  private JButton redButton;
  private JButton greyButton;
  private JButton valueButton;
  private JButton lumaButton;
  private JButton intensityButton;
  private JButton brightenButton;
  private JButton sepiaButton;
  private JButton blurButton;
  private JButton sharpenButton;
  private JButton viewOriginalButton;

  /**
   * Default constructor for SwingGUI.
   */
  public GUIView() {

    super("Image Processor");
    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());

    JPanel imagePanel = new JPanel();
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    imagePanel.setLayout(new GridLayout(1, 0, 10, 10));
    this.add(imagePanel);

    imageLabel = new JLabel();
    imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(400, 400));
    imagePanel.add(imageScrollPane);

    box = new JPanel();
    TitledBorder tb = BorderFactory.createTitledBorder("Commands");
    tb.setTitleJustification(TitledBorder.CENTER);
    box.setBorder(tb);
    box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
    this.add(box);

    redButton = new JButton("Red");
    redButton.setActionCommand("Red Button");
    box.add(redButton);

    greenButton = new JButton("Green");
    greenButton.setActionCommand("Green Button");
    box.add(greenButton);

    blueButton = new JButton("Blue");
    blueButton.setActionCommand("Blue Button");
    box.add(blueButton);

    greyButton = new JButton("Grey");
    greyButton.setActionCommand("Grey Button");
    box.add(greyButton);

    vFlipButton = new JButton("Vertical Flip");
    vFlipButton.setActionCommand("V-Flip Button");
    vFlipButton.setSize(50, 25);
    box.add(vFlipButton);

    hFlipButton = new JButton("Horizontal Flip");
    hFlipButton.setActionCommand("H-Flip Button");
    box.add(hFlipButton);

    lumaButton = new JButton("Luma");
    lumaButton.setActionCommand("Luma Button");
    box.add(lumaButton);

    valueButton = new JButton("Value");
    valueButton.setActionCommand("Value Button");
    box.add(valueButton);

    intensityButton = new JButton("Intensity");
    intensityButton.setActionCommand("Intensity Button");
    box.add(intensityButton);

    brightenButton = new JButton("Brighten");
    brightenButton.setActionCommand("Brighten Button");
    box.add(brightenButton);

    increment = new JTextField(5);
    this.setInputString("0");
    box.add(increment);

    sepiaButton = new JButton("Sepia");
    sepiaButton.setActionCommand("Sepia Button");
    box.add(sepiaButton);

    blurButton = new JButton("Blur");
    blurButton.setActionCommand("Blur Button");
    box.add(blurButton);

    sharpenButton = new JButton("Sharpen");
    sharpenButton.setActionCommand("Sharpen Button");
    box.add(sharpenButton);

    viewOriginalButton = new JButton("View Original");
    viewOriginalButton.setActionCommand("View Original Button");
    box.add(viewOriginalButton);

    fileOpenButton = new JButton("Open a file");
    fileOpenButton.setActionCommand("Open file");
    box.add(fileOpenButton);

    fileSaveButton = new JButton("Save a file");
    fileSaveButton.setActionCommand("Save file");
    box.add(fileSaveButton);

    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    box.add(exitButton);

    base = new JPanel();


    JLabel color = new JLabel("Color Code");
    color.setText("Red : Red Frequency, Green : Green Frequency, Blue : Blue Frequency, " +
            "Black : Intensity Frequency");
    base.add(color);

    TitledBorder tb3 = BorderFactory.createTitledBorder("Histogram");
    tb3.setTitleJustification(TitledBorder.CENTER);
    base.setBorder(tb3);
    base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
    base.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(base);

    this.pack();
  }

  /**
   * Creates a file chooser which helps user save a given image.
   *
   * @return the saved image file.
   */
  public File saveHelp() {
    File f = null;
    final JFileChooser saver = new JFileChooser(".");
    int ret = saver.showSaveDialog(null);
    if (ret == JFileChooser.APPROVE_OPTION) {
      f = saver.getSelectedFile();
    }
    return f;
  }

  /**
   * Creates a file chooser which helps user load a given image.
   *
   * @return the image file to be loaded.
   */
  public File loadHelp() {
    File f = null;
    final JFileChooser choose = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Images", "jpg", "gif", "png", "ppm", "bmp");
    choose.setFileFilter(filter);
    int response = choose.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      f = choose.getSelectedFile();
    }
    return f;
  }

  /**
   * Displays this view.
   */
  @Override
  public void display() {
    setVisible(true);
  }

  /**
   * Adds this image to the view.
   *
   * @param img represents the given image.
   */
  @Override
  public void addImage(Image img) {
    this.curImg = img;
    BufferedImage done = ImageUtil.createImage(img);
    imageLabel.setIcon(new ImageIcon(done));
    hist.setImg(img);
    hist.repaint();
    this.refresh();
  }

  /**
   * Returns the current image.
   *
   * @return the current image.
   */
  @Override
  public Image getCurrent() {
    return this.curImg;
  }

  /**
   * Adds features to our GUI view.
   *
   * @param features represents the feautures to be added.
   */
  @Override
  public void addFeatures(Filters filters) {
    fileOpenButton.addActionListener(evt -> features.load());
    exitButton.addActionListener(evt -> features.exit());
    redButton.addActionListener(evt -> features.red());
    fileSaveButton.addActionListener(evt -> features.save());
    greenButton.addActionListener(evt -> features.green());
    blueButton.addActionListener(evt -> features.blue());
    greyButton.addActionListener(evt -> features.grey());
    hFlipButton.addActionListener(evt -> features.hflip());
    vFlipButton.addActionListener(evt -> features.vflip());
    lumaButton.addActionListener(evt -> features.luma());
    valueButton.addActionListener(evt -> features.value());
    intensityButton.addActionListener(evt -> features.intensity());
    brightenButton.addActionListener(evt -> features.brighten());
    sepiaButton.addActionListener(evt -> features.sepia());
    blurButton.addActionListener(evt -> features.blur());
    sharpenButton.addActionListener(evt -> features.sharpen());
    viewOriginalButton.addActionListener(evt -> features.viewOriginal());
  }

  /**
   * Refresh the screen.
   * This is called when the something on the screen is updated, therefore it must be redrawn.
   */
  @Override
  public void refresh() {
    this.clearInputString();
    this.repaint();
  }

  /**
   * Returns the input string from our view.
   *
   * @return the input in increment.
   */
  @Override
  public String getInputString() {
    return increment.getText();
  }

  /**
   * Clears the in put in increment.
   */
  @Override
  public void clearInputString() {
    this.setInputString("");
  }

  /**
   * Sets the input string of our brighten field to a given value.
   *
   * @param s represents the value to brighten value.
   */
  @Override
  public void setInputString(String s) {
    increment.setText(s);
  }


  @Override
  public void renderMessage(String message) throws IOException {
  }

  /**
   * Renders the state of the model.
   *
   * @throws IOException if transmission fails.
   */
  @Override
  public void renderState() throws IOException {
  }


}
