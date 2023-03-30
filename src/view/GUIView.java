package view;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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

   /**
   * Creates a window where files can be chosen by the user.
   *
   * @return the image file to be loaded.
   */
  public File fileChooser() {
    File f = null;
    final JFileChooser choose = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Images", "ppm", "collage");
    choose.setFileFilter(filter);
    int response = choose.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      f = choose.getSelectedFile();
    }
    return f;
  }

}
