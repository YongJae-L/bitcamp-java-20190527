package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  private LessonDao lessonDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext appCtx = (ApplicationContext)getServletContext().getAttribute("iocContainer");
    lessonDao = appCtx.getBean(LessonDao.class);
  }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업명 상세</title></head>");
    out.println("<body><h1>수업명 상세</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Lesson lesson = lessonDao.findBy(no);
      if (lesson == null) {
        out.println("해당 번호의 데이터가 없습니다!");
        return;
      }
      out.println("<form action='/lesson/update' method='post'>");
      out.printf("수업번호 : <input type='text' name='no' value='%s' readonly><br>\n",lesson.getNo());
      out.printf("수업명 : <input type='text' name='title' value='%s'><br>\n",lesson.getTitle());
      out.printf("수업내용 : <textarea name='contents' rows='5'"
          + " cols='50'>%s</textarea><br>\n",
          lesson.getContents());
      out.printf("기간: <input type='text' name='startDate' value='%s'>\n", lesson.getStartDate());
      out.printf("~ <input type='text' name='endDate' value='%s'><br>\n", lesson.getEndDate());
      out.printf("총수업시간: <input type='text' name='totalHours' value='%d'>\n", lesson.getTotalHours());
      out.printf("일수업시간: <input type='text' name='dayHours' value='%d'><br>\n", lesson.getDayHours());
      out.println("<button>변경</button>");
      out.printf("<a href='/lesson/delete?no=%d'>삭제</a>",lesson.getNo());
      out.println("</form>");
    } catch (Exception e) {
      out.println("데이터 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }

}












