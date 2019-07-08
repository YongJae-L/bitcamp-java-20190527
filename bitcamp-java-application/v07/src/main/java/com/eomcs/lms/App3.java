package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner keyboard;
  public static void main(String[] args) {
    keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    Board[] boards = new Board[LENGTH];
    
    int i = 0;
    while (i < LENGTH) {
      Board board = new Board();

      board.no = getIntValue("번호? ");
      board.contents = getStringValue("내용? ");
      board.createdDate = new Date(System.currentTimeMillis()); 
      board.viewCount = 0;
      boards[i] = board;
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
    
    // 배열에 입력한 개수만큼 출력한다.
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-10s, %s, %d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }
  private static String getStringValue(String message) {
    System.out.print(message);
    return  keyboard.nextLine();
}

//private static Date getDateValue(String message) {
//  while (true) {
//    try {
//      System.out.print(message);
//      return  Date.valueOf(keyboard.nextLine());
//    } catch (IllegalArgumentException e) {
//      System.out.println("2019-07-05 형식으로 입력하세요.");
//    }
//  }
//}

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
