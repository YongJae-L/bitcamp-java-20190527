package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner keyboard;
  public static void main(String[] args) {
    keyboard = new Scanner(System.in);
    int[] no = new int[100];
    String[] contents = new String[100];
    Date[] createdDate = new Date[100];
    int viewCount=0;
    int i=0;
    for(;i<100;i++) {
    no[i] = Integer.parseInt(intValue("번호? "));
    contents[i] = stringValue("내용? ");
    createdDate[i] = new Date(dateValue());
    System.out.println("계속 입력하시겠습니까?(Y/n)");
    String response = keyboard.nextLine();
    if(response.equals("n") ) {
      break;
    }
    }
    
    System.out.println();
    
    for(int i2=0;i2<=i;i2++) {
    System.out.printf("번호: %d\n", no[i2]);
    System.out.printf("내용: %s\n", contents[i2]);
    System.out.printf("작성일: %s\n", createdDate[i2]);
    System.out.printf("조회수: %d\n\n", viewCount);
    }
  }
  
  private static String intValue(String m) {
    while(true) {
      try {
        System.out.println(m);
        return keyboard.nextLine();
      } catch (Exception e) {
        System.out.println("숫자를 입력해주세요.");
      }
    }
  }
  
  private static String stringValue(String m) {
    System.out.println(m);
    return keyboard.nextLine();
  }
  
  private static long dateValue() {
    return System.currentTimeMillis();
  }
}
