// 캡슐화 : 적용 전
package ch12.d;

public class Test02 {
  
  public static void main(String[] args) {
    
    Patient2 p = new Patient2();
    
    p.name = "김영희";
    p.setAge(20);
    p.setWeight(60);
    p.setHeight(157);
    p.setGender(Patient2.WOMAN);
    
    System.out.println(p);
    
    Patient2 p2 = new Patient2();
    p2.name = "이철희";
    p2.setAge(300); 
    p2.setWeight(-50);
    p2.setHeight(400);
    p2.setGender(3);
    
    System.out.println(p2);
  }
  
  //"추상화"가 무너지게 되지 않도록 클래스 목적(추상화ㅑ 목적)에 맞춰
  // 인스턴스 변수에 무효한 값이 들어가지 않도록 해야 한다.
  // 그럴 목적으로 만든 문법이 캡슐화이다.
  // "캡슐화"? 추사화가 무너지지 않도록 인스턴스 멤버(변수와 메서드)의 접근을 제어하는 문법이다.
  // "추상화"? 실세계의 객체를 프로그램에서 다룰 수 있도록 클래스로 정의하는 것.
  // 추상화 기법?
  // - 데이터 타입을 정의
  // - 유관 메서드를 묶기

}
