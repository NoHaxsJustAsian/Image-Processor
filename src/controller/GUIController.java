package controller;

import java.awt.event.ActionEvent;

import javax.swing.*;

import model.Filters.RedFilter;
import model.IImageProcessorModel;
import view.GUIView;


public class GUIController implements Features{
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
        
        break;
      case "Green":
        break;
      case "Blue":
        break;
      case "Exit Button":
        System.exit(0);
        break;
    }
  }


  @Override
  public void newProject() {
  }

  @Override
  public void loadProject() {

  }

  @Override
  public void saveProject() {

  }

  @Override
  public void saveImage() {

  }

  @Override
  public void blueFilter() {

  }

  @Override
  public void brightenIntensity() {

  }

  @Override
  public void brightenLuma() {

  }

  @Override
  public void brightenValue() {

  }

  @Override
  public void darkenIntensity() {

  }

  @Override
  public void darkenLuma() {

  }

  @Override
  public void darkenValue() {

  }

  @Override
  public void greenFilter() {

  }

  @Override
  public void normal() {

  }

  @Override
  public void redFilter(String curLayer) {
     //FIXME: get the current layer from the user in some way.
    try {
      model.setFilter(curLayer, new RedFilter());
      view.addImageToGUI(model.compressImage());
    } catch (Exception e) {
      System.out.println("Please choose an layer.");
    }
  }
  }

  @Override
  public void screen() {

  }

  @Override
  public void multiply() {

  }

  @Override
  public void difference() {

  }

  @Override
  public void addLayer() {

  }

  @Override
  public void addImageToLayer() {


  }
}