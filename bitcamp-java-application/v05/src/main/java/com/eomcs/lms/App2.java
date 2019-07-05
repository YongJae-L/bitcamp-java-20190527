package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static Scanner keyboard;
  public static void main(String[] args) {
    keyboard = new Scanner(System.in);

    int no = Integer.parseInt(intValue("번호? "));
    String name = stringValue("이름? ");
    String email = stringValue("이메일? ");
    String password = stringValue("암호? ");
    String photo = stringValue("사진? ");
    String tel = stringValue("전화? ");
    Date registeredDate = new Date(dateValue()); 
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", password);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n", tel);
    System.out.printf("가입일: %s\n", registeredDate);
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
