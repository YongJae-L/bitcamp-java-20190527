package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Component;
import com.eomcs.util.Input;
import com.eomcs.util.RequestMapping;

@Component
public class CalcCommand {
  
  @RequestMapping("/calc/plus")
  public void calcAdd(BufferedReader in, PrintStream out) {
    try {
      int a = Input.getIntValue(in, out, "값1? ");
      int b = Input.getIntValue(in, out, "값2? ");
      int sum = a+b;
      out.println(a+" "+b+" = "+sum);
      
      
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
