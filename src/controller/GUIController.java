package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import model.Filters.BrightenLuma;
import model.Filters.RedFilter;
import model.IImageProcessorModel;
import view.GUIView;
import view.IImageProcessorView;


public class GUIController extends JFrame implements Features{
  private JPanel panel;
  private GUIView view;
  private IImageProcessorModel model;



  public GUIController(GUIView view,  IImageProcessorModel model) {
    super();
    this.view = view;
    this.model = model;

    this.view.RedFilterButton.setActionCommand("Red");
    this.view.RedFilterButton.addActionListener();

    view.setListener();
    view.display();


    this.pack();
    this.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    String nameLayer = "";
    String nameFilter = "";
    switch(e.getActionCommand()) {
      case "Red":
        //FIXME: some input from user to get the name of the layer
        nameFilter = "Red";
        //set the filter of the layer to red
        this.model.setFilter(nameLayer, new RedFilter());
        //show that layer to the user
        view.
        break;
      case "Green":
        break;
      case "Blue":
        break;
      case "Exit Botton":
        System.exit(0);
        break;
    }
  }



}