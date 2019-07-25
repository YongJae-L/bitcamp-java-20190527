package com.eomcs.lms.handler;

import com.eomcs.util.Input;

public class CalcPlusCommand implements Command {
  Input input;
  
  public CalcPlusCommand(Input input){
    this.input=input;
  }
  
  @Override
  public void execute() {
    int num1 = input.getIntValue("값1? ");
    int num2 = input.getIntValue("값2? ");
    System.out.println("합계는 "+(num1+num2)+" 입니다.");
    
  }
}
