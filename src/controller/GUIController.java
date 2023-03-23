package controller;

import java.io.IOException;

import javax.swing.*;

import view.IImageProcessorView;

public class GUIController extends JFrame implements IImageProcessorView {
  JPanel panel;

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
}
