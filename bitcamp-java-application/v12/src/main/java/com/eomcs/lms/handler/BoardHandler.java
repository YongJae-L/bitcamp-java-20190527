package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Input;

public class BoardHandler {
  private static Board[] boards = new Board[100];
  private static int boardsSize=0;
  
  public static void listBoard() {
    if(boardsSize==0)
      System.out.println("게시물이 존재하지 않습니다.");
      for (int i = 0; i < boardsSize; i++) {
        System.out.printf("%d, %s, %s, %d\n",
            boards[i].no, boards[i].contents, boards[i].createdDate, boards[i].viewCount);
      }
  }

  public static void addBoard() {
    Board board = new Board();
    board.no = Input.getIntValue("번호? ");
    board.contents = Input.getStringValue("내용? ");
    board.createdDate = new Date(System.currentTimeMillis()); 
    board.viewCount = 0;
    boards[boardsSize++] = board;
    System.out.println("저장되었습니다.");
  }
}
