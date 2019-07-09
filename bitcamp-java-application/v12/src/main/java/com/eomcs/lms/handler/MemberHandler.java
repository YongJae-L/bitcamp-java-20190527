package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Input;

public class MemberHandler {

  private static Member[] members = new Member[100];
  private static int membersSize=0;
  
  public static void listMember() {
    if(membersSize==0) 
      System.out.println("맴버가 존재하지 않습니다.");
      for (int i = 0; i < membersSize; i++) {
        System.out.printf("%d, %s, %s, %s, %s\n", 
            members[i].no, members[i].name, members[i].email, 
            members[i].tel, members[i].registeredDate);
      }
  }

  public static void addMember() {
    Member member = new Member();
    
    member.no = Input.getIntValue("번호? ");
    member.name = Input.getStringValue("이름? ");
    member.email = Input.getStringValue("이메일");
    member.password = Input.getStringValue("암호?");
    member.photo = Input.getStringValue("사진?");
    member.tel = Input.getStringValue("전화?");
    member.registeredDate = new Date(System.currentTimeMillis());
    
    members[membersSize++] = member;
    System.out.println("저장되었습니다.");
  }
}
