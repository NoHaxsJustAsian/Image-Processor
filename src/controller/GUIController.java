package controller;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import view.IImageProcessorView;

public class GUIController extends JFrame implements IImageProcessorView {
  private JPanel panel;
  private JPanel imagesPanel;
  private JScrollPane imageScroll;
  private JLabel imageLabel;

  public GUIController() {
    super();
    panel = new JPanel();

    this.pack();
    this.setVisible(true);
  }

  @Override
  public void renderMessage(String message) throws IOException {
    JOptionPane.showMessageDialog(this, message);
  }

  @Override
  public void renderState() throws IOException {

  }


  /**
   * Displays the current image with scroll ability.
   */
  private void displayImage() {
    imageLabel = new JLabel();
    imageScroll = new JScrollPane(imageLabel);
    imageScroll.setPreferredSize(new Dimension(500, 500));
  }


  public void createImage() {
    imagesPanel.setSize(new Dimension(150, 150));
    imagesPanel.setBorder(BorderFactory.createTitledBorder("Images:"));
    imagesPanel.setLayout(new FlowLayout());
  }

  /**
   * Call method to refresh panel, this typically happens when a new filter is set, or a new image
   * is added, or when a new layer is placed.
   */
  public void updateImage() {

  }
}
