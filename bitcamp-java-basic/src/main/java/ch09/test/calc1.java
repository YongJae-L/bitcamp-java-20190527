package ch09.test;

// 계산 기능과 관련된 메서드를 별도의 블록으로 분리할 때 사용하는 문법이 "클래스"이다.
public class calc1 {
  
  int result;
  
  static void plus(calc1 that, int a) {
    that.result += a;
  }
  
  static void minus(calc1 that, int a) {
    that.result -= a;
  }
  
  static void multiple(calc1 that, int a) {
    that.result *= a;
  }
  
  static void divide(calc1 that, int a) {
    that.result /= a;
  }
}









