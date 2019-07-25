// 애플리케이션 예외의 종류: Exception 계열의 예외와 RuntimeException 계열의 예외
package ch21.c;

import java.util.ArrayList;

public class Test01_2 {

  public static void main(String[] args) {
    // 2) RuntimeException 계열의 예외
    // => Exception 클래스의 서브 클래스이다.
    // => 이 계열의 예외가 발생하는 경우에는 "예외 처리"가 필수가 아니다.
    //    선택이다.
    //    즉 try ~ catch를 쓰지 않아도 컴파일 오류가 발생하지 않는다.
    // => 그러나 예외를 처리하지 않으면  메서드 호출자에게 예외가 전달된다.
    //    메서드 호출자 또한 예외를 처리하지 않으면 그 상위 호출자에게 전달된다.
    //    애플리케이션을 개발할 때 이런 예외도 처리하도록 하라!
    // 예:
    // execute() 메서드 
    // => PlusCommand나 DivideCommand의 execute() 메서드는 
    //    내부적으로 NumberFormatException, ArithmeticException 이 발생한다.
    // => 그런데 이들 예외는 RuntimeException 계열이라서 
    //    catch 블록에서 예외를 반드시 받아야 하는 것은 아니다.
    // => 그래서 아래의 try ~ catch 블록에 이들 예외를 처리하는 catch 블록이 없는 것이다.
    //
    ArrayList<String> list = new ArrayList<>();
    //System.out.println(list.get(0));
    divide(100,2);
    divide(100,0);
  }
  static int divide(int a, int b) throws RuntimeException {
    if(b==0)
      throw new RuntimeException();
    return a/b;
  }
}
