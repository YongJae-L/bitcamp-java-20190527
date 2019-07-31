package design_pattern.observer.after;

public class Test03 {

  public static void main(String[] args) {
    Car car = new Car();
    
    
    car.addObserver(new SafeBeltCarObserver());
    
    //새 옵저버 등록
    car.addObserver(new EngineOilCarObserver());
    
    car.start();
    car.run();
    car.stop();
  }

}








