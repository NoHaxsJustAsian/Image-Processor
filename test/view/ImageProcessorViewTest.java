package view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import model.ImageProcessorModel;

import static org.junit.Assert.*;

/**
 * Represents a class for testing the view class.
 */
public class ImageProcessorViewTest {

  ImageProcessorModel model;

  ImageProcessorView view;
  private StringBuilder sb; //acts as an Appendable

  @Before
  public void setupModelAndView() {
    model = new ImageProcessorModel(200, 200);
    sb = new StringBuilder();
    view =  new ImageProcessorView(model, sb);
  }


  @Test
  public void testRenderMessage() {
    try {
      view.renderMessage("message");
    } catch (IOException e) {
      fail();
    }
    assertEquals("message", sb.toString());

  }
}