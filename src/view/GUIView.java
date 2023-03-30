package view;

import java.io.IOException;

import javax.swing.*;

  /**
   * Clears the in put in increment.
   */
  @Override
  public void clearInputString() {
    this.setInputString("");
  }

  /**
   * Sets the input string of our brighten field to a given value.
   *
   * @param s represents the value to brighten value.
   */
  @Override
  public void setInputString(String s) {
    increment.setText(s);
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
