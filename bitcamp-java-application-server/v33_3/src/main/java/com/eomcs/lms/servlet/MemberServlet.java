package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberServlet implements Servlet {
  
  MemberDao memberDao;
  
  public MemberServlet(MemberDao memberDao) {
    
    this.memberDao = memberDao;
  }
  
  @Override
  public void service(String command, ObjectInputStream in, ObjectOutputStream out) throws Exception {
    switch (command) {
      case "/member/add":
        addMember(in, out);
        break;
      case "/member/list":
        listMember(in, out);
        break;
      case "/member/delete":
        deleteMember(in, out);
        break;  
      case "/member/detail":
        detailMember(in, out);
        break;
      case "/member/update":
        updateMember(in, out);
        break;
      default:
        out.writeUTF("fail");
        out.writeUTF("지원하지 않는 명령입니다.");
    }
  }
  
  private void updateMember(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Member member = (Member)in.readObject();
    
    // 변경일은 서버쪽에서 설정해야 한다.
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    if (memberDao.update(member) == 0) {
      fail("해당 번호의 회원이 없습니다.",out);
      return;
    }
    
    out.writeUTF("ok");
  }

  private void detailMember(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    
    Member member = memberDao.findBy(no);
    if (member == null) {
      fail("해당 회원의 수업이 없습니다.",out);
      return;
    }
    out.writeUTF("ok");
    out.writeObject(member);
  }

  private void deleteMember(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    
    if (memberDao.delete(no) == 0) {
      fail("해당 번호의 회원이 없습니다.",out);
      return;
    }
    out.writeUTF("ok");
  }

  private void addMember(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Member member = (Member)in.readObject();
    
    // 등록일은 서버쪽에서 설정해야 한다.
    member.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    if (memberDao.insert(member) == 0) {
      fail("회원을 입력할 수 없습니다.",out);
      return;
    }
    
    out.writeUTF("ok");
  }
  
  private void listMember(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("ok");
    out.reset(); // 기존에 serialize 했던 객체의 상태를 무시하고 다시 serialize 한다.
    out.writeObject(memberDao.findAll());
  }
  
  private void fail(String cause, ObjectOutputStream out) throws Exception {
    out.writeUTF("fail");
    out.writeUTF(cause);
  }

}
