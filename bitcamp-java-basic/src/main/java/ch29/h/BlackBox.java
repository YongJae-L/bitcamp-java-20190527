package ch29.h;

public class BlackBox {
  private String maker;
  private String model;
  
  public BlackBox() {
    System.out.println("BlackBox()");
  }
  
  @Override
  public String toString() {
    return "BlackBox [maker=" + maker + ", model=" + model + "]";
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
System.out.println("BlacBox.setMaker()");
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("BlacBox.setModel()");
    this.model = model;
  }
  
  
}
