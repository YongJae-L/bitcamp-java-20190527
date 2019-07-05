package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner keyboard;
  public static void main(String[] args) {
    keyboard = new Scanner(System.in);

    int no = Integer.parseInt(intValue("번호? "));
    String contents = stringValue("내용? ? ");
    Date createdDate = new Date(dateValue()); 
    
    int viewCount = 0;
    
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("작성일: %s\n", createdDate);
    System.out.printf("조회수: %d\n", viewCount);
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
