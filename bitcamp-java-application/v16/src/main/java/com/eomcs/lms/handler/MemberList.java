package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {
  private Member[] members = new Member[100];
  private int size=0;
  public int getSize() {
    return size;
  }
  
  public void add(Member member) {
    this.members[size++] = member;
  }
  
  public Member[] toArray() {
    Member[] arr = new Member[this.size];
    for(int i=0;i<this.size;i++) {
      arr[i] = members[i];
    }
    return arr;
    
  }
  
  
  
}
