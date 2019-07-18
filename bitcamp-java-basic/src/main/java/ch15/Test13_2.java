// Object 클래스 - clone() : shallow copy
package ch15;
 
public class Test13_2 {
  
  static class Name implements Cloneable{
    String name;
    
    public Name(String name) {
      this.name=name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      return super.clone();
    }

    @Override
    public String toString() {
      return "Name [name=" + name + "]";
    }
    
  }
 
  
  static class Engine implements Cloneable {
    int cc;
    int valve;
    
    public Engine(int cc, int valve) {
      this.cc=cc;
      this.valve=valve;
    }

    @Override
    public String toString() {
      return "Engine [cc=" + cc + ", valve=" + valve + "]";
    }

    @Override
    protected Engine clone() throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      return (Engine) super.clone();
    }
    
  }
  
  static class Car implements Cloneable {
    String maker;
    Name name;
    Engine engine;
    
    public Car(String maker, Name name, Engine engine) {
      this.maker = maker;
      this.name = name;
      this.engine=engine;
    }

    @Override
    public String toString() {
      return "Car [maker=" + maker + ", name=" + name + ", engine=" + engine + "]";
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
      //deep copy
      // => 포함하고 있는 하위 객체에 대한 복제를 수행하려면 다음과 같이
      //    개발자가 직접 코드를 작성해야 한다.
      // clone() : 인스턴스를 복제할 때 쓰는 메서드
      Car copy = (Car) super.clone();
      copy.engine = copy.engine.clone();
      copy.name = (Name) copy.name.clone();
      return copy;
      
    }
  }
  
  public static void main(String[] args) throws Exception {
    Engine engine = new Engine(3000, 16);
    Name name = new Name("비트비트");
    Car car = new Car("비트자동차", name, engine);
    
    //자동차 복제
    Car car2 = car.clone();
    
    System.out.println(car == car2);
    System.out.println(car);
    System.out.println(car2);
    System.out.println(car.engine==car2.engine);
    System.out.println(car.name==car2.name);
    System.out.println(car.engine.cc==car2.engine.cc);
    
    Car test = new Car("비트자동차2", name, engine);
    Car test2 = test;
    System.out.println(test==test2);
    test2 = test.clone();
    System.out.println(test==test2);
    
    String add = "123123";
    int ad = add.hashCode();
    
    // 클론은 기본적으로 딥 클론을 하지 않는데 이 객체가 포함하고 있는 다른 객체까지 자동적으로 하지 않는다 해당 객체만 복제한다.
    // clone()은 해당 객체의 필드 값만 복제한다.
    // 그 객체가 포함하고 있는 하위 객체는 복제하지 않는다.
    // "shallow copy(얖은 복제)"라 부른다.
    //
    // 그 객체가 포함하고 있는 하위 객체까지 복제하는 것을
    // "deep copy"라 부른다.
    // deep copy(깊은 복제)는 개발자가 직접 clone() 메서드 안에
    // deep copy 를 수행하는 코드를 작성해야 한다.
   
  }
}







