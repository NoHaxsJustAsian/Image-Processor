package model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Filters.BlueFilter;
import model.Filters.DarkenLuma;
import model.Filters.GreenFilter;
import model.Filters.IFilter;

import static org.junit.Assert.*;

public class ImageProcessorModelTest {


  IFilter darkenLuma = new DarkenLuma();
  private List<ILayer> orderLayers;

  @Before
  void init(){
    HashMap<String, ILayer> nameLayers = new HashMap<String, ILayer>();

    nameLayers.put("first", darkenLuma);
    nameLayers.put("second", );

    Map<String, Image> storedImages;
    Pixel[][] pixels;
    Image image;
    pixels = new Pixel[2][2];
    pixels[0][0] = new Pixel(64, 16, 0);
    pixels[0][1] = new Pixel(32, 8, 8);
    pixels[1][0] = new Pixel(0, 0, 80);
    pixels[1][1] = new Pixel(160, 160, 160);

    image = new Image(2, 2, 255, pixels);

    storedImages = new HashMap<>();

    model = new BetterImageProcessorModel(storedImages);

    this.model.add("image", image);



  }



  ImageProcessorModel model = new ImageProcessorModel(400,400, ,);

  @Test
  public void getHeight() {
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