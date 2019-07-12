package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Input;

public class MemberHandler {

  private MemberList memberlist = new MemberList();
  private Input input;
  public MemberHandler(Input input){
    this.input=input;
  }
  public void listMember() {
    if(memberlist.getSize()==0) 
      System.out.println("맴버가 존재하지 않습니다.");
    Member[] member = memberlist.toArray();
      for (Member members : member) {
        System.out.printf("%d, %s, %s, %s, %s\n", 
            members.getNo(), members.getName(), members.getEmail(), 
            members.getTel(), members.getRegisteredDate());
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
