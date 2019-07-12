// 캡슐화 : 적용 전
package ch12.d;

public class Test01 {
  
  public static void main(String[] args) {
    Patient p = new Patient();
    p.name = "김영희";
    p.age = 20;
    p.weight=60;
    p.height= 157;
    p.gender= Patient2.WOMAN;
    System.out.println(p);
    
    // 환자를 컴퓨터에서 다루려면 데이터화 해야 한다.
    // Patient는 이럴 목적으로 정의한 클래스이다.
    // 이렇게 Patient의 경우처럼 컴퓨터에서 다루기 위해 데이터화하여 정의하는 것을
    // "추상화"라 부른다.
    // 꼭 데이터만 해당하는 것은 아니다.
    // MemberHandler 클래스의 경우처럼 특정 업무를 정의하는 것도
    // "추상화"라 부른다.
    // => 즉 실세계의 객체(예: 사람, 물건, 업무 등)를 컴퓨터에서 다룰 수 있도록 클래스로 정의하는 행위를 "추상화"라 부른다.
    
    Patient p2 = new Patient();
    p2.name = "이철희";
    p2.age = 30;
    p2.weight=78;
    p2.height= 186;
    p2.gender= Patient2.MAN;
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
