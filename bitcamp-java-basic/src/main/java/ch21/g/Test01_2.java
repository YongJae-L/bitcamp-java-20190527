// 예외 처리 연습
package ch21.g;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test01_2 {

  public static void main(String[] args) {
    FileReader in;
    
      try {
        in = new FileReader("build.gradle");
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } // 컴파이 오류!
      // Exception 예외인 경우 반드시 예외 처리를 요구한다.
      // (RuntimeException은 제외)

  }

}
