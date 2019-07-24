package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {

  private List<Member> memberlist;

  public MemberListCommand(List<Member> list){

    this.memberlist=list;
  }
  
  @Override
  public void execute() {
    Member[] members = memberlist.toArray(new Member[] {});
      for (Member member : members) {
        System.out.printf("%d, %s, %s, %s, %s\n", 
            member.getNo(), member.getName(), member.getEmail(), 
            member.getTel(), member.getRegisteredDate());
      }
  }
  
}
