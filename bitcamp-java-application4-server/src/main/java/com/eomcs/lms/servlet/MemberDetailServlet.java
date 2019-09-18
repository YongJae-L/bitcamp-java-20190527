package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext appCtx = (ApplicationContext)getServletContext().getAttribute("iocContainer");
    memberDao = appCtx.getBean(MemberDao.class);
  }

  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
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
      out.println("<form action='/member/update' method='post'>");
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

}