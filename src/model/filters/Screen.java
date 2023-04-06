package model.filters;

import java.util.List;

import model.ILayer;
import model.IPixel;
import swingdemo.RepresentationConverter;
import model.IHSL;

/**
 * Represents a Screen filter.
 */
public class Screen implements IFilter {

  String name;

  /**
   * Constructs a screen filter.
   */
  public Screen() {
    this.name = "screen";
  }

  /**
   * Applies the filter to the given layer.
   * @param layers a list of layers.
   * @return IPixel[][] is the new image.
   */
  @Override
  public IPixel[][] apply(List<ILayer> layers, ILayer layer) {
    IPixel[][] pixels1 = layer.getCanvas();
    IPixel[][] compPixels = new IPixel[layer.getHeight()][layer.getWidth()];
    IPixel[][] finalPixels = new IPixel[layer.getHeight()][layer.getWidth()];

    for (int x = layers.indexOf(layer) + 1; x < layers.size() - 1; x++) {
      ILayer layerCurrent = layers.get(x);
      layerCurrent.setCanvas(layerCurrent.getFilter().apply(layers, layerCurrent));
      for (int i = 0; i < layer.getHeight(); i++) {
        for (int j = 0; j < layer.getWidth(); j++) {
          compPixels[i][j] = layers.get(i).getPixel(i, j);
        }
      }
    }

    for (int z = 0; z < layer.getHeight(); z++) {
      for (int y = 0; y < layer.getWidth(); y++) {
        IPixel holderRGBTop = pixels1[z][y];
        IPixel holderRGBBottom = compPixels[z][y];

        IHSL holderHSLTop = RepresentationConverter.convertRGBtoHSL(holderRGBTop.getRed(),
                holderRGBTop.getGreen(), holderRGBTop.getBlue());
        IHSL holderHSLBottom = RepresentationConverter.convertRGBtoHSL(holderRGBBottom.getRed(),
                holderRGBBottom.getGreen(), holderRGBBottom.getBlue());

        double hue = holderHSLTop.getHue();
        double saturation = holderHSLTop.getSaturation();
        double lightness =  1 - ((1 - holderHSLTop.getLightness())
                * (1 - holderHSLBottom.getLightness()));

        finalPixels[z][y] = RepresentationConverter.convertHSLtoRGB(hue, saturation, lightness);
      }
    }

    return finalPixels;
  }

  /**
   * Gets the name of the filter.
   *
   * @return string name of the filter.
   */
  public String getName() {
    return this.name;
  }
}
