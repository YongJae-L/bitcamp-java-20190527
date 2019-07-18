package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;

public class BoardHandler {
  private ArrayList<Board> boardList = new ArrayList<>();
  private Input input;
  //BoardHandler 가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  //Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를
  // "의존 객체(dependency)"라 부른다.
  public BoardHandler(Input input) {
    this.input=input;
  }
  public void listBoard() {
//    Board[] boards = new Board[boardList.size()];     //적당한 사이즈 배열 넘기기.
//    boardList.toArray(boards);
    Board[] boards = boardList.toArray(new Board[] {}); //빈 배열 넘기기.
      for (Board board : boards) {
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
  public void detailBoard() {
    int no = input.getIntValue("번호? ");
    Board board = null;
    for(int i=0;i<boardList.size();i++) {
      Board temp = boardList.get(i);
      if(temp.getNo() == no) {
        board = temp;
        break;
      }
    }
    if( board == null) {
      System.out.println("해당 번호의 데이터가 없습니다!");
      return;
    }

    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
    
  }
  public void updateBoard() {
    int no = input.getIntValue("번호? ");
    Board board = null;
    for(int i=0;i<boardList.size();i++) {
      Board temp = boardList.get(i);
      if(temp.getNo() == no) {
        board = temp;
        break;
      }
    }
    if( board == null) {
      System.out.println("해당 번호의 데이터가 없습니다!");
      return;
    }
    String str = input.getStringValue("수업명("+board.getContents()+")? ");
    if(str.length()>0) {
      board.setContents(str);
    }
    System.out.println("데이터를 변경하였습니다.");
  }
  public void deleteBoard() {
    int no = input.getIntValue("번호? ");
    for(int i=0;i<boardList.size();i++) {
      Board temp = boardList.get(i);
      if(temp.getNo()==no) {
        boardList.remove(i);
        System.out.println("데이터를 삭제하였습니다.");
        return;
      }
    }
    System.out.println("해당 번호의 데이터가 없습니다!");
  }
}
