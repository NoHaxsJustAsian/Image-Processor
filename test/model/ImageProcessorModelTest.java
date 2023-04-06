package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.filters.BlueFilter;
import model.filters.BrightenIntensity;
import model.filters.BrightenLuma;
import model.filters.BrightenValue;
import model.filters.DarkenIntensity;
import model.filters.DarkenLuma;
import model.filters.DarkenValue;
import model.filters.GreenFilter;
import model.filters.IFilter;
import model.filters.Multiply;
import model.filters.Normal;
import model.filters.RedFilter;
import model.filters.Difference;
import model.filters.Screen;

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

  IFilter difference = new Difference();
  IFilter multiply = new Multiply();
  IFilter screen = new Screen();

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

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("green", second);


    first.addImage(image, 0, 0);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("red")
            .getFilter().apply(model1.getLayers(), model1.getLayer("red"));
    model1.getLayer("red").setCanvas(hold);

    assertEquals("redFilter", redFilter.getName());
    assertEquals("red", first.getName());
    assertEquals(50, model1.getLayer("red").getPixel(0, 0).getRed());
    assertEquals(0, model1.getLayer("red").getPixel(0, 0).getGreen());
  }

  @Test
  public void testGreenFilter() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 1, 1);


    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(first);

    nameLayers.put("green", first);
    first.addImage(image, 0, 0);

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("blue", blueFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("blue", second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("green")
            .getFilter().apply(model1.getLayers(), model1.getLayer("green"));
    model1.getLayer("green").setCanvas(hold);

    assertEquals("greenFilter", greenFilter.getName());
    assertEquals("green", first.getName());
    assertEquals(0, model1.getLayer("green").getPixel(0, 0).getRed());
    assertEquals(50, model1.getLayer("green").getPixel(0, 0).getGreen());
  }

  @Test
  public void testBrightenIntensity() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(30, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("brightenIntensity", brightenIntensity, 200, 200);
    first.addImage(image, 0, 0);

    nameLayers.put("brightenIntensity", first);
    orderLayers.add(first);

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("green", second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("brightenIntensity").getFilter()
            .apply(model1.getLayers(), model1.getLayer("brightenIntensity"));
    model1.getLayer("brightenIntensity").setCanvas(hold);

    assertEquals(40, model1.getLayer("brightenIntensity").getPixel(0, 0).getRed());

  }

  @Test
  public void testBrightenLuma() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("brightenLuma", brightenLuma, 200, 200);
    first.addImage(image, 0, 0);

    nameLayers.put("brightenLuma", first);
    orderLayers.add(first);

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("green", second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("brightenLuma").getFilter()
            .apply(model1.getLayers(), model1.getLayer("brightenLuma"));
    model1.getLayer("brightenLuma").setCanvas(hold);

    assertEquals(100, model1.getLayer("brightenLuma").getPixel(0, 0).getRed());


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

    nameLayers.put("brightenValue", first);
    orderLayers.add(first);
    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("green", second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("brightenValue").getFilter()
            .apply(model1.getLayers(), model1.getLayer("brightenValue"));
    model1.getLayer("brightenValue").setCanvas(hold);

    assertEquals(100, model1.getLayer("brightenValue").getPixel(0, 0).getRed());

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

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("green", second);

    nameLayers.put("darkenIntensity", first);
    orderLayers.add(first);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("darkenIntensity").getFilter()
            .apply(model1.getLayers(), model1.getLayer("darkenIntensity"));
    model1.getLayer("darkenIntensity").setCanvas(hold);

    assertEquals(0, model1.getLayer("darkenIntensity").getPixel(0, 0).getRed());

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

    nameLayers.put("darkenLuma", first);
    orderLayers.add(first);

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(50, 50, 0, 255);
    image2 = new PPMImage(pixels2, 1, 1);
    ILayer second = new Layer("green", greenFilter, 200, 200);
    orderLayers.add(second);
    nameLayers.put("green", second);
    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("darkenLuma").getFilter()
            .apply(model1.getLayers(), model1.getLayer("darkenLuma"));
    model1.getLayer("darkenLuma").setCanvas(hold);


    assertEquals(0, model1.getLayer("darkenLuma").getPixel(0, 0).getRed());

  }


  @Test
  public void testDarkenValue() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ILayer first = new Layer("normal", normal, 200, 200);
    first.addImage(image, 0, 0);

    ILayer second = new Layer("darkenValue", darkenValue, 200, 200);
    second.addImage(image, 0, 0);

    ILayer third = new Layer("green", greenFilter, 200, 200);
    third.addImage(image, 0, 0);

    nameLayers.put("normal", first);
    orderLayers.add(first);

    nameLayers.put("darkenValue", second);
    orderLayers.add(second);

    nameLayers.put("green", third);
    orderLayers.add(third);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    IPixel[][] hold = model1.getLayer("normal").getFilter()
            .apply(model1.getLayers(), model1.getLayer("normal"));
    model1.getLayer("normal").setCanvas(hold);

    IPixel[][] hold1 = model1.getLayer("darkenValue").getFilter()
            .apply(model1.getLayers(), model1.getLayer("darkenValue"));
    model1.getLayer("darkenValue").setCanvas(hold1);

    IPixel[][] hold2 = model1.getLayer("green").getFilter()
            .apply(model1.getLayers(), model1.getLayer("green"));
    model1.getLayer("green").setCanvas(hold2);


    assertEquals(50, model1.getLayer("normal").getPixel(0, 0).getRed());
    assertEquals(0, model1.getLayer("darkenValue").getPixel(0, 0).getRed());
    assertEquals(0, model1.getLayer("green").getPixel(0, 0).getRed());


    model1.getLayer("normal").setFilter(darkenValue);
    IPixel[][] hold3 = model1.getLayer("normal").getFilter()
            .apply(model1.getLayers(), model1.getLayer("normal"));
    model1.getLayer("normal").setCanvas(hold3);

    assertEquals(0, model1.getLayer("normal").getPixel(0, 0).getRed());


    model1.getLayer("darkenValue").setFilter(redFilter);
    IPixel[][] hold4 = model1.getLayer("darkenValue").getFilter()
            .apply(model1.getLayers(), model1.getLayer("darkenValue"));
    model1.getLayer("darkenValue").setCanvas(hold4);

    assertEquals(0, model1.getLayer("darkenValue").getPixel(0, 0).getRed());

  }


  @Test
  public void Difference() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(25, 25,10, 255);
    image2 = new PPMImage(pixels2, 1, 1);

    Pixel[][] pixels3;
    PPMImage image3;
    pixels3 = new Pixel[1][1];
    pixels3[0][0] = new Pixel(50, 50, 0, 255);
    image3 = new PPMImage(pixels3, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    ILayer first = new Layer("difference", difference, 200, 200);
    first.addImage(image, 0, 0);

    ILayer second = new Layer("bottom", normal, 200, 200);
    second.addImage(image2, 0, 0);

    ILayer third = new Layer("bottom2", normal, 200, 200);
    third.addImage(image3, 0, 0);

    orderLayers.add(first);
    nameLayers.put("difference", first);
    orderLayers.add(second);
    nameLayers.put("bottom", second);
    orderLayers.add(third);
    nameLayers.put("bottom2", third);

    IPixel[][] hold = model1.getLayer("difference")
            .getFilter().apply(model1.getLayers(), model1.getLayer("difference"));
    model1.getLayer("difference").setCanvas(hold);

    assertEquals("difference", difference.getName());
    assertEquals("difference", first.getName());
    assertEquals(25, model1.getLayer("difference").getPixel(0, 0).getRed());
    assertEquals(25, model1.getLayer("difference").getPixel(0, 0).getGreen());
    assertEquals(10, model1.getLayer("difference").getPixel(0, 0).getBlue());
  }

  @Test
  public void Multiply() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 50, 0, 255);
    image = new PPMImage(pixels, 1, 1);

    Pixel[][] pixels2;
    PPMImage image2;
    pixels2 = new Pixel[1][1];
    pixels2[0][0] = new Pixel(25, 25,10, 255);
    image2 = new PPMImage(pixels2, 1, 1);

    Pixel[][] pixels3;
    PPMImage image3;
    pixels3 = new Pixel[1][1];
    pixels3[0][0] = new Pixel(50, 50, 15, 255);
    image3 = new PPMImage(pixels3, 1, 1);

    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200,
            nameLayers, orderLayers);

    ILayer first = new Layer("multiply", multiply, 200, 200);


    assertEquals("multiply", multiply.getName());
    assertEquals("multiply", first.getName());
  }

  @Test
  public void Screen() {
    Pixel[][] pixels;
    PPMImage image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(50, 0, 0, 255);
    image = new PPMImage(pixels, 1, 1);
    assertEquals("screen", screen.getName());

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
    List<ILayer> orderLayers = new ArrayList<>();
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();
    ImageProcessorModel model2 =
            new ImageProcessorModel(200,200, nameLayers, orderLayers, 255);

    assertEquals(255, model2.getMaxValue());
    assertEquals(0, model.getMaxValue());
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
    assertEquals(second, model1.getLayer("2"));
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
    ILayer third = new Layer("3", normal, 200, 200);
    nameLayers.put("2", second);

    List<ILayer> orderLayers = new ArrayList<>();
    orderLayers.add(first);
    orderLayers.add(second);

    ImageProcessorModel model1 = new ImageProcessorModel(200, 200, nameLayers, orderLayers);

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

    model1.newProject(200, 200, 255);
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




}