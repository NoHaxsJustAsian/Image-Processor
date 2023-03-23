package view;

import java.io.IOException;

import javax.swing.*;

public class GUIView extends JFrame implements IImageProcessorView{

  public GUIView(){
    super();
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
