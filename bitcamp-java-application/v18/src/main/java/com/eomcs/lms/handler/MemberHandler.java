package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;

public class MemberHandler {

  private ArrayList<Member> memberlist = new ArrayList<>();
  private Input input;
  public MemberHandler(Input input){
    this.input=input;
  }
  public void listMember() {
    Member[] members = memberlist.toArray(new Member[] {});
      for (Member member : members) {
        System.out.printf("%d, %s, %s, %s, %s\n", 
            member.getNo(), member.getName(), member.getEmail(), 
            member.getTel(), member.getRegisteredDate());
      }
  }

  public  void addMember() {
    Member member = new Member();
    
    member.setNo(input.getIntValue("번호? "));
    member.setName(input.getStringValue("이름? "));
    member.setEmail(input.getStringValue("이메일"));
    member.setPassword(input.getStringValue("암호?"));
    member.setPhoto(input.getStringValue("사진?"));
    member.setTel(input.getStringValue("전화?"));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    memberlist.add(member);
    System.out.println("저장되었습니다.");
  }
}
