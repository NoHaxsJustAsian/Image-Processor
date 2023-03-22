package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

import static org.junit.Assert.assertEquals;

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
  public void init() {

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
    first.addImage(image, 0, 0);
    nameLayers.put("1", first);

    ILayer second = new Layer("2", normal, 200, 200);
    second.addImage(imagee, 1, 1);
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


    ImageProcessorModel model = new ImageProcessorModel(200, 200);
    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

  }

  @Test
  public void testRedFilter() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("red", redFilter, 200, 200);
    orderLayers.add(first);

    nameLayers.put("red", first);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("red").getFilter().apply(model1.getLayer("red"));
    model1.getLayer("red").setCanvas(hold);

    assertEquals("redFilter", redFilter.getName());
    assertEquals("red", first.getName());
    assertEquals(50, model1.getLayer("red").getPixel(0, 0).getRed());
    assertEquals(0, model1.getLayer("red").getPixel(0, 0).getGreen());
  }

  @Test
  public void testGreenFilter() {

    ImageProcessorModel model = new ImageProcessorModel(200, 200);

    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("green", greenFilter, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(0, model1.getLayer("green").getPixel(0, 0).getRed());
    assertEquals(50, model1.getLayer("green").getPixel(0, 0).getGreen());
  }

  @Test
  public void testBlueFilter() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("blue", blueFilter, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(0, model1.getLayer("blue").getPixel(0, 0).getRed());
    assertEquals(50, model1.getLayer("blue").getPixel(0, 0).getBlue());
  }

  @Test
  public void testBrightenIntensity() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(30, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("brightenIntensity", brightenIntensity, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(40, model1.getLayer("red").getPixel(0, 0).getRed());

  }

  @Test
  public void testBrightenLuma() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("brightenLuma", brightenLuma, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(51, model1.getLayer("red").getPixel(0, 0).getRed());


  }

  @Test
  public void testBrightenValue() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 50, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("brightenValue", brightenValue, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(100, model1.getLayer("red").getPixel(0, 0).getRed());

  }


  @Test
  public void testDarkenIntensity() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(30, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("darkenIntensity", darkenIntensity, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(20, model1.getLayer("red").getPixel(0, 0).getRed());

  }

  @Test
  public void testDarkenLuma() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("darkenLuma", darkenLuma, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(0, model1.getLayer("red").getPixel(0, 0).getRed());

  }


  @Test
  public void testDarkenValue() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("darkenValue", darkenValue, 200, 200);
    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    assertEquals(0, model1.getLayer("red").getPixel(0, 0).getRed());

  }

  @Test
  public void getHeight() {
    ImageProcessorModel model = new ImageProcessorModel(200, 200);
    assertEquals(200, model.getHeight());
  }

  @Test
  public void getWidth() {
    ImageProcessorModel model = new ImageProcessorModel(200, 200);
    assertEquals(200, model.getWidth());
  }

  @Test
  public void getMaxValue() {
    ImageProcessorModel model = new ImageProcessorModel(200, 200);
    assertEquals(255, model.getMaxValue());
  }

  @Test
  public void getLayer() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    assertEquals(first, model1.getLayer(0));
    assertEquals(second, model1.getLayer(1));
  }

  @Test
  public void testGetLayer() {
    //FIXME: this test is not working
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    assertEquals(first, model1.getLayer("1"));
    assertEquals(first, model1.getLayer("2"));
  }


  @Test
  public void getLayers() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    assertEquals(orderLayers, model1.getLayers());
  }

  @Test
  public void swapLayers() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    model1.swapLayers(0, 1);
    assertEquals(second, model1.getLayer(0));
  }

  @Test
  public void testSwapLayers() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    model1.swapLayers("1", "2");
    assertEquals(second, model1.getLayer(0));
  }

  @Test
  public void getLayerPosition() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    assertEquals(0, model1.getLayerPosition("1"));
    assertEquals(1, model1.getLayerPosition("2"));
  }

  @Test
  public void addLayer() {
    //FIXME: this test is not working
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    ILayer third = new Layer("3", normal, 200, 200);
    model1.addLayer("3", redFilter);
    assertEquals(third, model1.getLayer("3"));
  }

  @Test
  public void newProject() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    model1.newProject(200, 200);
    assertEquals(200, model1.getWidth());
    assertEquals(200, model1.getHeight());
  }

  @Test
  public void setFilter() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);
    ILayer second = new Layer("2", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

    model1.setFilter("1", redFilter);
    assertEquals(redFilter, model1.getLayer("1").getFilter());
  }

  @Test
  public void addImage() {
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("1", normal, 200, 200);
    nameLayers.put("1", first);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);

    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    pixels[0][1] = new Pixel(0, 50, 0, 255);
    pixels[1][0] = new Pixel(0, 0, 50, 255);
    pixels[1][1] = new Pixel(50, 50, 50, 255);
    image = new PPMImage(pixels, 2, 2);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);
    first.addImage(image, 0, 0);

    assertEquals(50, model1.getLayer("1").getPixel(0, 0).getRed());
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