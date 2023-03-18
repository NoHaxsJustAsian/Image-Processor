package model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import static org.junit.Assert.*;

/**
 * Represents tests for the model class.
 */
public class ImageProcessorModelTest {

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

    ILayer first = new Layer("normal", normal, 200, 200);
    first.addImage(image, 0,0);
    nameLayers.put("1", first);

    ILayer second = new Layer("norm", normal, 200, 200);
    first.addImage(imagee, 0,1);
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
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 2, 2);

    ILayer first = new Layer("red", redFilter, 200, 200);
    first.addImage(image, 0,0);

    assertEquals(0, first.getPixel(0,0).getGreen());
    assertEquals(50, first.getPixel(0,0).getRed());

  }

  @Test
  public void testGreenFilter() {

    ImageProcessorModel model = new ImageProcessorModel(200,200);

    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("green", greenFilter, 200, 200);
    first.addImage(image, 0,0);

    saveImage();

    assertEquals(0, first.getPixel(0,0).getRed());
    assertEquals(50, first.getPixel(0,0).getGreen());
  }

  public void testBlueFilter() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("blue", blueFilter, 200, 200);
    first.addImage(image, 0,0);

    assertEquals(0, first.getPixel(0,0).getRed());
    assertEquals(50, first.getPixel(0,0).getBlue());
  }


  public void testBrightenIntensity() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("brightenIntensity", brightenIntensity, 200, 200);
    first.addImage(image, 0,0);

  }


  public void testBrightenLuma() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("brightenLuma", brightenLuma, 200, 200);
    first.addImage(image, 0,0);

  }


  public void testBrightenValue() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("brightenValue", brightenValue, 200, 200);
    first.addImage(image, 0,0);

  }



  public void testDarkenIntensity() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("darkenIntensity", darkenIntensity, 200, 200);
    first.addImage(image, 0,0);

  }


  public void testDarkenLuma() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("darkenLuma", darkenLuma, 200, 200);
    first.addImage(image, 0,0);

  }


  public void testDarkenValue() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    ILayer first = new Layer("darkenValue", darkenValue, 200, 200);
    first.addImage(image, 0,0);


  }




  @Test
  public void getHeight() {
    ImageProcessorModel model = new ImageProcessorModel(200,200);
    assertEquals(200, model.getHeight());
  }

  @Test
  public void getWidth() {
    ImageProcessorModel model = new ImageProcessorModel(200,200);
    assertEquals(200, model.getWidth());
  }

  @Test
  public void getMaxValue() {
    ImageProcessorModel model = new ImageProcessorModel(200,200);
    assertEquals(255, model.getMaxValue());
  }

  @Test
  public void getLayer() {
    ImageProcessorModel model = new ImageProcessorModel(200,200);
    assertEquals(255, model.getMaxValue());

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