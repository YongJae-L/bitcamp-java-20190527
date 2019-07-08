// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  
  static Scanner keyScan;
  
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new java.util.Scanner(keyboard);
    
    Lesson[] lessons = new Lesson[100];
    
    int[] no=new int[100];
    int i=0;
    for (;i<no.length;i++) {
      Lesson lesson = new Lesson();
      
      lesson.no = getIntValue("번호? ");
      lesson.title = getStringValue("수업명? ");
      lesson.contents = getStringValue("설명? ");
      lesson.startDate= getDateValue("시작일? ");
      lesson.endDate = getDateValue("종료일? ");
      lesson.totalHours = getIntValue("총수업시간? ");
      lesson.dayHours = getIntValue("일수업시간? ");
      
      lessons[i] = lesson;
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String response = keyScan.nextLine();
      if(response.equals("n") ) {
        break;
      }
    }
    System.out.println();
    int i2=0;
    while(i2<=i) {
//    System.out.printf("번호: %d\n", no[i2]);
//    System.out.printf("수업명: %s\n", lectureName[i2]);
//    System.out.printf("설명: %s\n", description[i2]);
//    System.out.printf("시작일: %s\n", startDate[i2]);
//    System.out.printf("종료일: %s\n" , endDate[i2]);
//    System.out.printf("총수업시간: %s\n" , totalHours[i2]);
//    System.out.printf("일수업시간: %s\n\n" , dayHours[i2]);
    System.out.printf("%s %s %s %s ~ %s %s %s\n",lessons[i2].no,lessons[i2].title,lessons[i2].contents,lessons[i2].startDate,lessons[i2].endDate,lessons[i2].totalHours,lessons[i2].dayHours);
    i2++;
    }
  }
  
  private static String getStringValue(String message) {
        System.out.print(message);
        return  keyScan.nextLine();
  }

  private static Date getDateValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return  Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }

  private static int getIntValue(String message){
    while (true) {
      try {
        System.out.print(message);
        return  Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }
  
}