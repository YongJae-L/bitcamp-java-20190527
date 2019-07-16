package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;

public class BoardHandler {
  private ArrayList boardList = new ArrayList();
  private Input input;
  //BoardHandler 가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  //Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를
  // "의존 객체(dependency)"라 부른다.
  public BoardHandler(Input input) {
    this.input=input;
  }
  public void listBoard() {
    Object[] list = boardList.toArray();
      for (Object obj : list) {
        Board board = (Board)obj;
        System.out.printf("%d, %s, %s, %d\n",
            board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
      }
  }

  public void addBoard() {
    Board board = new Board();
    board.setNo(input.getIntValue("번호? "));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    board.setViewCount(0);
    boardList.add(board);
    System.out.println("저장되었습니다.");
  }
}
