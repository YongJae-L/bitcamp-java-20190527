package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  private List<Board> list;
  //BoardHandler 가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  //Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를
  // "의존 객체(dependency)"라 부른다.
  public BoardListCommand(List<Board> list) {
    this.list=list;
  }
  @Override
  public void execute() {
//    Board[] boards = new Board[boardList.size()];     //적당한 사이즈 배열 넘기기.
//    boardList.toArray(boards);
    Board[] boards = list.toArray(new Board[] {}); //빈 배열 넘기기.
      for (Board board : boards) {
        System.out.printf("%d, %s, %s, %d\n",
            board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
      }
  }

}
