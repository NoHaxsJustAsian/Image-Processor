package controller;

import model.ImageProcessorModel;

public class ImageProcessorController implements IImageProcessorController{
  int width;
  int height;

  final ImageProcessorModel model = new ImageProcessorModel(height, width);

}
