package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;

public class MemberUpdateCommand implements Command {

  private List<Member> list;
  private Input input;
  public MemberUpdateCommand(Input input, List<Member> list){
    this.input=input;
    this.list=list;
  }

  @Override
  public void execute() {
    int no = input.getIntValue("번호? ");
    Member member=null;
    for(int i=0;i<list.size();i++) {
      Member temp = list.get(i);
      if(no==temp.getNo()) {
        member = temp;
        break;
      }
    }
    if( member == null) {
      System.out.println("해당 번호의 데이터가 없습니다!");
      return;
    }
    String str = input.getStringValue("이름("+member.getName()+")? ");
    if(str.length()>0) {
      member.setName(str);
    }
    member.setEmail(input.getStringValue("이메일("+member.getEmail()+")? "));
    member.setEmail(input.getStringValue("암호("+member.getPassword()+")? "));
    member.setEmail(input.getStringValue("사진("+member.getPhoto()+")? "));
    member.setEmail(input.getStringValue("전화("+member.getTel()+")? "));
    System.out.println("회원을 변경했습니다.");
  }
  
}
