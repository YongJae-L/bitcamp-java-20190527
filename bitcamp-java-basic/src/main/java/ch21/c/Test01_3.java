// 애플리케이션 예외의 종류: main() 과 RuntimeException
package ch21.c;

import java.util.Scanner;

public class Test01_3 {

  public static void main(String[] args) {
    
    Scanner keyScan = new Scanner(System.in);
    
    while (true) {
      try {
      System.out.println("값1? ");
      int a= Integer.parseInt(keyScan.nextLine());
      
      System.out.println("값2? ");
      int b= Integer.parseInt(keyScan.nextLine());
      
      System.out.println(divide(a,b));
      } catch (RuntimeException e) {
        System.out.println("입력 또는 계산 중에 오류 발생!");
      }
    }
  }
  static int divide(int a, int b) throws RuntimeException {
    if(b==0)
      throw new RuntimeException("0으로 나눌 수 없습니다.");
    return a/b;
  }
}
