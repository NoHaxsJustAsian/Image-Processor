package model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Filters.BlueFilter;
import model.Filters.BrightenLuma;
import model.Filters.DarkenLuma;
import model.Filters.GreenFilter;
import model.Filters.IFilter;
import model.Filters.Normal;
import model.Filters.RedFilter;

import static org.junit.Assert.*;

/**
 * Represents tests for the model class.
 */
public class ImageProcessorModelTest {

  IFilter normal = new Normal();
  IFilter redFilter = new RedFilter();
  IFilter darkenLuma = new DarkenLuma();

  IFilter brightenLuma = new BrightenLuma();



  @Before
  void init(){


    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    pixels[0][1] = new Pixel(0, 50, 0, 255);
    pixels[1][0] = new Pixel(0, 0, 50, 255);
    pixels[1][1] = new Pixel(50, 50, 50, 255);
    image = new PPMImage(pixels, 50, 50);


    Pixel[][] pixelss;
    PPMImage imagee;
    pixelss = new Pixel[2][2];
    pixelss[0][0] = new Pixel(50, 0, 0, 255);
    pixelss[0][1] = new Pixel(0, 50, 0, 255);
    pixelss[1][0] = new Pixel(0, 0, 50, 255);
    pixelss[1][1] = new Pixel(50, 50, 50, 255);
    imagee = new PPMImage(pixelss, 50, 50);




    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("normal", normal, 200, 200);
    first.addImage(image, 0,0);
    nameLayers.put("1", first);

    ILayer second = new Layer("norm", normal, 200, 200);
    first.addImage(imagee, 25,25);
    nameLayers.put("2", second);

    ILayer third = new Layer("red", redFilter, 200, 200);
    nameLayers.put("3", third);

    ILayer fourth = new Layer("darken", darkenLuma, 200, 200);
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
  public void testRedFilter() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    pixels[0][1] = new Pixel(0, 50, 0, 255);
    pixels[1][0] = new Pixel(0, 0, 50, 255);
    pixels[1][1] = new Pixel(50, 50, 50, 255);
    image = new PPMImage(pixels, 50, 50);

    ILayer first = new Layer("red", redFilter, 200, 200);
    first.addImage(image, 0,0);

    assertEquals(image.getPixel(0,1), new Pixel(50,0,0, 255));
  }


  @Test
  public void testBrightenLuma() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    pixels[0][1] = new Pixel(0, 50, 0, 255);
    pixels[1][0] = new Pixel(0, 0, 50, 255);
    pixels[1][1] = new Pixel(50, 50, 50, 255);
    image = new PPMImage(pixels, 50, 50);

    ILayer first = new Layer("brighten", brightenLuma, 200, 200);
    first.addImage(image, 0,0);

    assertEquals(image.getPixel(0,1), new Pixel(100,0,0, 255));
  }


  @Test
  public void getHeight() {
    model()
  }

  @Test
  public void getWidth() {
  }

  @Test
  public void getMaxValue() {
  }

  @Test
  public void getLayer() {
  }

  @Test
  public void testGetLayer() {
  }

  @Test
  public void getLayers() {
  }

  @Test
  public void swapLayers() {
  }

  @Test
  public void testSwapLayers() {
  }

  @Test
  public void getLayerPosition() {
  }

  @Test
  public void addLayer() {
  }

  @Test
  public void newProject() {
  }

  @Test
  public void setFilter() {
  }

  @Test
  public void addImage() {
  }

  @Test
  public void saveImage() {
  }

  @Test
  public void saveProject() {
  }

  @Test
  public void loadProject() {
  }
}