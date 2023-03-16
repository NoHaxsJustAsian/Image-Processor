package controller;
import java.util.Scanner;

import model.IImageProcessorModel;

import model.ImageProcessorModel;
import view.IImageProcessorView;


/**
 * This class implements the IImageProcessor Controller.
 */
public class ImageProcessorController implements IImageProcessorController{

  int width;
  int height;

  ImageProcessorModel model = new ImageProcessorModel(height, width);

  private IImageProcessorView view;

  private Readable object;




  public ImageProcessorController(ImageProcessorModel model, IImageProcessorView view, Readable object) {
    if (model == null || view == null || object == null) {
      throw new IllegalArgumentException("invalid arguments");
    }
    this.model = model;
    this.view = view;
    this.object = object;
  }


  /**
   * This method should start a new Program.
   */
  public void startProcessor() {
    Scanner s = new Scanner(this.object);

  }

}
