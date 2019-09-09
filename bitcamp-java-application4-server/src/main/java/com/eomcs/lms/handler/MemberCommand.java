package com.eomcs.lms.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component
public class MemberCommand {
  private MemberDao memberDao;

  public MemberCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @RequestMapping("/member/form") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void form(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>유저 등록폼</title></head>");
    out.println("<body><h1>유저 등록</h1>");
    out.println("<form action='/member/add'>");
    out.println("이름: <input type='text' name = 'name'><br>\n");
    out.println("이메일: <input type='text' name = 'email'><br>\n");
    out.println("암호: <input type='text' name = 'password'><br>\n");
    out.println("사진: <input type='text' name = 'photo'><br>\n");
    out.println("전화: <input type='text' name = 'tel'><br>\n");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/add") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void add(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>유저 등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=/member/list'>"
        + "</head>");
    out.println("<body><h1>유저 등록</h1>");
    try {
      Member member = new Member();
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setPhoto(request.getParameter("photo"));
      member.setTel(request.getParameter("tel"));
      memberDao.insert(member);
      out.println("저장하였습니다.");
      
    } catch (Exception e) {
      out.println("데이터 저장에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
  @RequestMapping("/member/delete") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void delete(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=/member/list'>"
        + "</head>");
    out.println("<body><h1>수업 삭제</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (memberDao.delete(no) > 0) {
        out.println("데이터를 삭제하였습니다.");
      } else {
        out.println("해당 데이터가 없습니다.");
      }

    } catch (Exception e) {
      out.println("데이터 삭제에 실패했습니다!");
      System.out.println(e.getMessage());
    }

  }
  
  @RequestMapping("/member/detail") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void detail(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>유저 상세</title></head>");
    out.println("<body><h1>유저 상세</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      
      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("해당 번호의 데이터가 없습니다!");
        return;
      }
      out.println("<form action='/member/update'>");
      out.printf("번호 : <input type='text' name='no' value='%d'><br>\n",member.getNo());
      out.printf("이름 : <input type='text' name='name' value='%s'><br>\n",member.getName());
      out.printf("이메일 : <input type='text' name='email' value='%s'><br>\n",member.getEmail());
      out.printf("암호 : <input type='text' name='password' value='%s'><br>\n",member.getPassword());
      out.printf("사진 : <input type='text' name='photo' value='%s'><br>\n",member.getPhoto());
      out.printf("전화 : <input type='text' name='tel' value='%s'><br>\n",member.getTel());
      out.printf("가입일 : <input type='text' name='regDate' value='%s' readonly><br>\n",member.getRegisteredDate());
      out.println("<button>변경</button>");
      out.printf("<a href='/member/delete?no=%d'>삭제</a>",member.getNo());
      out.println("</form>");
    } catch (Exception e) {
      out.println("데이터 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/list") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void list(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>유저 목록</title>"
        + "<link rel=\'stylesheet\' href=\'https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\' integrity=\'sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\' crossorigin=\'anonymous\'>"
        + "</head>");
    out.println("<body><h1>유저 목록</h1>");
    out.println("<a href='/member/form'>유저 추가</a><br>");
    try {
      out.println("<table class='table'>");
      out.println("<tr><th>번호</th><th>이름</th><th>이메일</th><th>전화번호</th><th>등록일</th></tr>");
      List<Member> members = memberDao.findAll();
      for (Member member : members) {
        out.printf("<tr><td><a href='/member/detail?no=%d'>%d</td>"
            +"<td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>\n",
            member.getNo(),member.getNo(), member.getName(), member.getEmail(),
            member.getTel(), member.getRegisteredDate());
      }
      out.println("</table>");
    } catch (Exception e) {
      out.println("데이터 목록 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/search") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void search(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>회원 검색</title>"
        + "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>"
        + "</head>");
    out.println("<body><h1>회원 검색</h1>");
    
    try {
      out.println("<table class='table table-hover'>");
      out.println("<tr><th>번호</th><th>이름</th><th>이메일</th><th>전화</th><th>등록일</th></tr>");
      
      List<Member> members = memberDao.findByKeyword(
          request.getParameter("keyword"));
      for (Member member : members) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td><a href='/member/detail?no=%d'>%s</a></td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td></tr>\n", 
            member.getNo(),
            member.getNo(),
            member.getName(), 
            member.getEmail(), 
            member.getTel(),
            member.getRegisteredDate());
      }
      out.println("</table>");
      
    } catch (Exception e) {
      out.println("<p>데이터 검색에 실패했습니다!</p>");
      throw new RuntimeException(e);
    
    } finally {
      out.println("</body></html>");
    }
  }
  @RequestMapping("/member/update") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void update(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>유저 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=/member/list'>"
        + "</head>");
    out.println("<body><h1>유저 변경</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      
      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("해당 번호의 데이터가 없습니다!");
        return;
      }
      
      // 사용자로부터 변경할 값을 입력 받는다.
      Member data = new Member();
      data.setNo(no);
      data.setName(request.getParameter("name"));
      data.setEmail((request.getParameter("email")));
      data.setPassword((request.getParameter("password")));
      data.setPhoto((request.getParameter("photo")));
      data.setTel((request.getParameter("tel")));
      
      memberDao.update(data);
      out.println("데이터를 변경하였습니다.");
    } catch (Exception e) {
      out.println("데이터 변경에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }
}
