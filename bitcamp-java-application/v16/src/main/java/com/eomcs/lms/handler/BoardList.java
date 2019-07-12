package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  private Board[] boards = new Board[100];
  private int size=0;
  
  public int getSize() {
    return size;
  }

  public void add(Board board) {
    this.boards[size++] =board;
  }
  
  public Board[] toArray() {
    Board[] arr = new Board[this.size];
    for(int i=0;i<this.size;i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }
  
  
}
