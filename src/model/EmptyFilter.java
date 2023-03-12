package model;

public class EmptyFilter implements IFilter{

  /**
   *
   * @param image
   * @return
   */
  public IImage apply(IImage image) {
    return image;
  }
}
