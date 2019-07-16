// Wrapper 클래스 : 사용 전 
package ch11;

import java.util.Date;

public class Test09_3 {
  public static void main(String[] args) {

    // 그런데 Wrapper 클래스를 사용하면 primitive도 인스턴스로 다룰 수 있기 때문에
    // primitive 데이터를 다루는 메서드를 여러 개 만들 필요가 없다.
    Integer obj1 = Integer.valueOf(100);
    Float obj2 = Float.valueOf(3.14f);
    Character obj3 = Character.valueOf('A');
    Boolean obj4 = Boolean.valueOf(true);
    
    
    printObject(obj1);
    printObject(obj2);
    printObject(obj3);
    printObject(obj4);
    
    
    
  }
  
  static void printObject(Object obj) {
    System.out.println("값 => " + obj.toString());
  }
}
















