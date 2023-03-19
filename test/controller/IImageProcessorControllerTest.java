package controller;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mocks.FailingAppendable;
import model.Filters.BlueFilter;
import model.Filters.BrightenIntensity;
import model.Filters.BrightenLuma;
import model.Filters.BrightenValue;
import model.Filters.DarkenIntensity;
import model.Filters.DarkenLuma;
import model.Filters.DarkenValue;
import model.Filters.GreenFilter;
import model.Filters.IFilter;
import model.Filters.Normal;
import model.Filters.RedFilter;
import model.ILayer;
import model.ImageProcessorModel;
import model.Layer;
import model.PPMImage;
import model.Pixel;
import view.ImageProcessorView;

import static org.junit.Assert.*;

public class IImageProcessorControllerTest {

  IFilter normal = new Normal();
  IFilter redFilter = new RedFilter();
  IFilter greenFilter = new GreenFilter();
  IFilter blueFilter = new BlueFilter();

  IFilter brightenIntensity = new BrightenIntensity();
  IFilter brightenLuma = new BrightenLuma();
  IFilter brightenValue = new BrightenValue();

  IFilter darkenIntensity = new DarkenIntensity();
  IFilter darkenLuma = new DarkenLuma();
  IFilter darkenValue = new DarkenValue();




  @Before
  public void init(){

    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    pixels[0][1] = new Pixel(0, 50, 0, 255);
    pixels[1][0] = new Pixel(0, 0, 50, 255);
    pixels[1][1] = new Pixel(50, 50, 50, 255);
    image = new PPMImage(pixels, 2, 2);


    Pixel[][] pixelss;
    PPMImage imagee;
    pixelss = new Pixel[2][2];
    pixelss[0][0] = new Pixel(50, 0, 0, 255);
    pixelss[0][1] = new Pixel(0, 50, 0, 255);
    pixelss[1][0] = new Pixel(0, 0, 50, 255);
    pixelss[1][1] = new Pixel(50, 50, 50, 255);
    imagee = new PPMImage(pixelss, 2, 2);



    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    first.addImage(image, 0,0);
    nameLayers.put("1", first);

    ILayer second = new Layer("2", normal, 200, 200);
    second.addImage(imagee, 1,1);
    nameLayers.put("2", second);

    ILayer third = new Layer("3", redFilter, 200, 200);
    nameLayers.put("3", third);

    ILayer fourth = new Layer("4", darkenLuma, 200, 200);
    nameLayers.put("4", fourth);


    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);
    orderLayers.add(third);
    orderLayers.add(fourth);


    ImageProcessorModel model = new ImageProcessorModel(200,200);
    ImageProcessorModel model1 = new ImageProcessorModel(200,200, nameLayers, orderLayers);

  }

  @Test
  public void startProcessor() {
    ImageProcessorModel model = new ImageProcessorModel(200,200);
    Readable read = new StringReader("q");
    Appendable out = new StringBuilder();
    ImageProcessorView view = new ImageProcessorView(model, out);
    IImageProcessorController control = new ImageProcessorController(model, view, read);

    control.startProcessor();

    assertEquals( "", out.toString());

  }

  @Test
  public void startProcessor1() {
    this.init();
    ImageProcessorModel model = new ImageProcessorModel(200,200);
    Readable read = new StringReader("new");
    Appendable out = new StringBuilder();
    ImageProcessorView view = new ImageProcessorView(model, out);
    IImageProcessorController control = new ImageProcessorController(model, view, read);

    control.startProcessor();

    assertEquals( "", out.toString());


  }

  @Test
  public void renderMessage() {
    ImageProcessorModel model = new ImageProcessorModel(200, 200);
    Readable read = new StringReader("message");
    Appendable out = new StringBuilder();
    ImageProcessorView view = new ImageProcessorView(model, out);
    IImageProcessorController control = new ImageProcessorController(model, view, read);

    view = new ImageProcessorView(model, new FailingAppendable());
    model.newProject(200, 200);
    try {
      view.renderMessage("message");
      fail();
    } catch (IOException e) {
      System.out.println("Error rendering");
    }

  }
}