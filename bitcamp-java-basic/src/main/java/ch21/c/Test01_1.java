// 애플리케이션 예외의 종류: Exception 계열의 예외와 RuntimeException 계열의 예외
package ch21.c;

public class Test01_1 {

  public static void main(String[] args) {
    // 1) Exception 계열의 예외 
    // => try ~ catch 를 강요하는 예외 
    // => 예외처리를 하지 않으면 컴파일 오류가 발생한다.
    // => 단 Exception의 자식 클래스인 RuntimeException은 제외한다.
    // 
    // 예:
    // forName() 메서드
    // => 파라미터로 지정한 클래스를 찾아 메모리에 로딩하는 일을 한다.
    // => 리턴 값은 로딩한 클래스의 정보이다. 
    // => 이 메서드는 파라미터에서 지정한 클래스를 찾지 못했을 때 
    //    ClassNotFoundException 예외를 발생시킨다.
    // => 이 예외는 Exception의 자식 클래스이다.
    //    Exception의 자식클래스이고 RuntimeException 계열이 아닐 경우 
    //    try ~ catch 블록으로 반드시 예외를 받도록 처리해야 한다.
    //
    // getConstructor() 메서드
    // => 생성자를 찾아 리턴한다.
    // => 만약 지정된 생성자를 찾지 못하면 NoSuchMethodException 예외가 발생한다.
    //    이 예외도 Exception 계열의 메서드이다.
    //    즉 반드시 try ~ catch 를 사용하여 예외를 처리해야 한다.
    //
    // newInstance() 메서드 
    // => 생성자를 이용하여 인스턴스를 만든다.
    // => 만약 인스턴스를 만들지 못한다면 InstantiationException 등의 예외가 발생한다.
    //    이 예외도 Exception 계열의 메서드이다.
    //    즉 반드시 try ~ catch 를 사용하여 예외를 처리해야 한다.
    // 
    
    // 클래스 이름으로 .class를 메모리에 로딩하기
    //Class.forName("java.lang.String"); // 컴파일 오류! 
    
    //이유?
    // forName() 메서드에서 파라미터에 지정한 클래스를 못 찾을 때에는
    // Exception의 직계 자식인 ClassNotFoundException이 발생한다.
    // 메서드 시그너처에 그렇게 정의되어 있다.
    // 위에서 설명한 대로 RuntimException이 아닌
    // Exception 계열의 예외가 발생할 수 있는 메서드를 호출할 때는
    // 반드시 try ~ catch ~로 예외처리를 해야 한다.
    
    // 해결책? 다음과 같이 try ~ cathc ~ 블록에서 호출하라!
      try {Class.forName("java.lang.String");
      } catch(ClassNotFoundException e) { // 컴파일 오류! 
        System.out.println("ClassNotFoundException 오류!");
      } finally {
        System.out.println("실행종료!");
      }
      
  }
  static int divide(int a, int b) throws Exception {
    if(b==0)
      throw new RuntimeException();
    return a/b;
  }
}
