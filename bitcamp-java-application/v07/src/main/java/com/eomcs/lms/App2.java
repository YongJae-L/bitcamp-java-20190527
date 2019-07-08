package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static Scanner keyboard;
  public static void main(String[] args) {
    
    keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    Member[] members = new Member[LENGTH];
    
    int i = 0;
    for(;i<members.length;i++) {
      Member member = new Member();
      
      member.no = getIntValue("번호? ");
      member.name = getStringValue("이름? ");
      member.email = getStringValue("이메일");
      member.password = getStringValue("암호?");
      member.photo = getStringValue("사진?");
      member.tel = getStringValue("전화?");
      member.registeredDate = getDateValue("날짜는 ?");
      
      members[i] = member;
      i++;
      
      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();
      
      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }

      System.out.println();
    }
    
    keyboard.close();
    
    System.out.println();
    
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].no, members[j].name, members[j].email, 
          members[j].tel, members[j].registeredDate);
    }
  }
  private static String getStringValue(String message) {
    System.out.print(message);
    return  keyboard.nextLine();
}

private static Date getDateValue(String message) {
  while (true) {
    try {
      System.out.print(message);
      return  Date.valueOf(keyboard.nextLine());
    } catch (IllegalArgumentException e) {
      System.out.println("2019-07-05 형식으로 입력하세요.");
    }
  }
}

private static int getIntValue(String message){
while (true) {
  try {
    System.out.print(message);
    return  Integer.parseInt(keyboard.nextLine());
  } catch (NumberFormatException e) {
    System.out.println("숫자를 입력하세요.");
  }
}
}
}
