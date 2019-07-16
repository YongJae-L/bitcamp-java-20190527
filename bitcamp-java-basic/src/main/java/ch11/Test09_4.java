// Wrapper 클래스 : 사용 전 
package ch11;

import java.util.Date;

public class Test09_4 {
  public static void main(String[] args) {
    // Wrapper 클래스의 가장 큰 목적!
    // => primitive 값을 포함하여 모든 값을 쉽게 주고 받기 위함이다.
    
    // Wrapper 클래스를 사용하지 않으면 다음과 같이 각 타입의 값을 처리할 메서드를 
    // 여러 개 만들어야 한다.
    printInt(100);
    printFloat(3.14f);
    // printInt("Hello"); // 컴파일 오류!
    String ss = "Hello";
    //printFloat(ss); // 파라미터 변수가 값을 요구하는 primitive 타입의 변수이다.
                    // 인스턴스의 주소를 넘길 수 없다.
    
    // 그런데 Wrapper 클래스를 사용하면 primitive도 인스턴스로 다룰 수 있기 때문에
    // primitive 데이터를 다루는 메서드를 여러 개 만들 필요가 없다.
    Integer x = Integer.valueOf(1000);
    Float y = Float.valueOf(3.14f);
    String z = "Hello";
    Date today = new Date();
    
    printObject(x); // primitive 값을 인스턴스에 담아서 넘길 수 있다. 
    printObject(y); // 이것이 Wrapper 클래스가 필요한 이유이다.
    printObject(z);
    printObject(today);
    
  }
  
  static void printInt(int i) {
    System.out.println("값 => " + i);
  }
  
  static void printFloat(float f) {
    System.out.println("값 => " + f);
  }
  
  static void printObject(Object obj) {
    System.out.println("값 => " + obj.toString());
  }
}
















