package controller;

import java.util.Scanner;

import model.IImageProcessorModel;
import view.IImageProcessorView;

/**
 * This class implements the IImageProcessor Controller.
 */
public class ImageProcessorController implements IImageProcessorController{

  private IImageProcessorModel model;

  private IImageProcessorView view;

  private Readable object;


  public ImageProcessorController(IImageProcessorModel model, IImageProcessorView view, Readable object) {
    if (model == null || view == null || object == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.model = model;
    this.view = view;
    this.object = object;
  }


  @Override
  public void startProcessor() {
    Scanner s = new Scanner(this.object);

  }

}
