package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import org.springframework.stereotype.Component;
import com.eomcs.util.Input;
import com.eomcs.util.RequestMapping;

//실습 과제:
//=> 다음과 같이 실행하도록 위 클래스를 완성하라!
//
/*
* > /calc/plus
* 값1? 100
* 값2? 200
* 100 + 200 = 300
* 
* 뺄셈도
*/ 

@Component
public class CalcCommand {
  
  @RequestMapping("/calc/plus")
  public void calcAdd(BufferedReader in, PrintStream out) {
    try {
      int a = Input.getIntValue(in, out, "값1? ");
      int b = Input.getIntValue(in, out, "값2? ");
      int sum = a+b;
      out.println(a+" + "+b+" = "+sum);
      
      
    } catch (Exception e) {
      out.println("실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
  @RequestMapping("/calc/minus")
  public void calcMinus(BufferedReader in, PrintStream out) {
    try {
      int a = Input.getIntValue(in, out, "값1? ");
      int b = Input.getIntValue(in, out, "값2? ");
      int c = a-b;
      out.println(a+" "+b+" = "+ c);
      
    } catch (Exception e) {
      out.println("실패했습니다!");
      System.out.println(e.getMessage());
    }
  }


}
