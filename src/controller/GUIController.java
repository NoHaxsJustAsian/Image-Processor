package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import view.GUIView;
import view.IImageProcessorView;


public class GUIController extends JFrame implements ActionListener {
  JPanel panel;
  GUIView view;


  public GUIController() {
    super();
    panel = new JPanel();

    this.pack();
    this.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {

  }
}