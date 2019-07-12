package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Input;

public class BoardHandler {
  private Board[] boards = new Board[100];
  private int boardsSize=0;
  private Input input;
  //BoardHandler 가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  //Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를
  // "의존 객체(dependency)"라 부른다.
  public BoardHandler(Input input) {
    this.input=input;
  }
  public void listBoard() {
    if(boardsSize==0)
      System.out.println("게시물이 존재하지 않습니다.");
      for (int i = 0; i < boardsSize; i++) {
        System.out.printf("%d, %s, %s, %d\n",
            boards[i].getNo(), boards[i].getContents(), boards[i].getCreatedDate(), boards[i].getViewCount());
      }
  }

  public void addBoard() {
    Board board = new Board();
    board.setNo(input.getIntValue("번호? "));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    board.setViewCount(0);
    boards[boardsSize++] = board;
    System.out.println("저장되었습니다.");
  }
}
