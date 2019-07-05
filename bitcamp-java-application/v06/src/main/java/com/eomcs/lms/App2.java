package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static Scanner keyboard;
  public static void main(String[] args) {
    keyboard = new Scanner(System.in);
    int [] no = new int[100];
    String [] name = new String[100];
    String [] email = new String[100];
    String [] password = new String[100];
    String [] photo = new String[100];
    String [] tel = new String[100];
    Date [] registeredDate = new Date[100];
    
    
    int i=0;
    for(;i<100;i++) {
    no[i] = Integer.parseInt(intValue("번호? "));
    name[i] = stringValue("이름? ");
    email[i] = stringValue("이메일? ");
    password[i] = stringValue("암호? ");
    photo[i] = stringValue("사진? ");
    tel[i] = stringValue("전화? ");
    registeredDate[i] = new Date(dateValue());
    System.out.println("계속 입력하시겠습니까?(Y/n)");
    String response = keyboard.nextLine();
    if(response.equals("n") ) {
      break;
    }
    }
    System.out.println();
    
    for(int i2=0 ; i2<=i;i2++) {
    System.out.printf("번호: %d\n", no[i2]);
    System.out.printf("이름: %s\n", name[i2]);
    System.out.printf("이메일: %s\n", email[i2]);
    System.out.printf("암호: %s\n", password[i2]);
    System.out.printf("사진: %s\n", photo[i2]);
    System.out.printf("전화: %s\n", tel[i2]);
    System.out.printf("가입일: %s\n\n", registeredDate[i2]);
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
