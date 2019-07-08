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
    int leesonsSize=0;
    Member[] members = new Member[100];
    int membersSize=0;
    Board[] boards = new Board[100];
    int boardsSize=0;

    while(true) {
      System.out.print("명령> ");
      String command = keyScan.nextLine();
      if(command.equals("quit")){
        System.out.println("시스템을 종료합니다.");
        break;
      }
        if(command.equals("/lesson/add")) {
        Lesson lesson = new Lesson();
        
        lesson.no = getIntValue("번호? ");
        lesson.title = getStringValue("수업명? ");
        lesson.contents = getStringValue("설명? ");
        lesson.startDate= getDateValue("시작일? ");
        lesson.endDate = getDateValue("종료일? ");
        lesson.totalHours = getIntValue("총수업시간? ");
        lesson.dayHours = getIntValue("일수업시간? ");
        
        lessons[leesonsSize++] = lesson;
        System.out.println("저장하였습니다.");
        } else if (command.equals("/lesson/list")) {
          if(leesonsSize==0)
            System.out.println("해당 리스트가 존재하지 않습니다.");
            for ( int i2 = 0; i2 < leesonsSize; i2++) {
              Lesson lesson = lessons[i2];
              System.out.printf("%s, %s, %s ~ %s, %s\n",
                  lesson.no, lesson.title, lesson.startDate, lesson.endDate, lesson.totalHours);
            }
        } else if (command.equals("/member/add")) {
          Member member = new Member();
          
          member.no = getIntValue("번호? ");
          member.name = getStringValue("이름? ");
          member.email = getStringValue("이메일");
          member.password = getStringValue("암호?");
          member.photo = getStringValue("사진?");
          member.tel = getStringValue("전화?");
          member.registeredDate = new Date(System.currentTimeMillis()); 
          
          members[membersSize++] = member;
          System.out.println("저장되었습니다.");
        } else if (command.equals("/member/list")) {
          if(membersSize==0) 
            System.out.println("맴버가 존재하지 않습니다.");
            for (int i = 0; i < membersSize; i++) {
              System.out.printf("%d, %s, %s, %s, %s\n", 
                  members[i].no, members[i].name, members[i].email, 
                  members[i].tel, members[i].registeredDate);
            }
        } else if (command.equals("/board/add")) {
          Board board = new Board();
          board.no = getIntValue("번호? ");
          board.contents = getStringValue("내용? ");
          board.createdDate = new Date(System.currentTimeMillis()); 
          board.viewCount = 0;
          boards[boardsSize++] = board;
          System.out.println("저장되었습니다.");
        } else if (command.equals("/board/list")) {
          if(boardsSize==0)
            System.out.println("게시물이 존재하지 않습니다.");
            for (int i = 0; i < boardsSize; i++) {
              System.out.printf("%d, %s, %s, %d\n", 
                  boards[i].no, boards[i].contents, boards[i].createdDate, boards[i].viewCount);
            }
        }
        else {
          System.out.println("해당 명령을 지원하지 않습니다!");
        }
        System.out.println();
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