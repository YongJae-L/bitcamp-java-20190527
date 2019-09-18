package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@WebServlet("/lesson/add")
public class LessonAddServlet extends HttpServlet {
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
    out.println("<html><head><title>수업 등록폼</title></head>");
    out.println("<body><h1>수업 등록폼</h1>");
    out.println("<form action='/lesson/add' method='post'>");
    out.println("수업명: <input type='text' name = 'title'><br>\n");
    out.println("설명: <textarea name='contents' rows='5' cols='50'></textarea><br>");
    out.println("시작일: <input type='text' name = 'startDate'><br>\n");
    out.println("종료일: <input type='text' name = 'endDate'><br>\n");
    out.println("총수업시간: <input type='text' name = 'totalHours'><br>\n");
    out.println("일수업시간: <input type='text' name = 'dayHours'><br>\n");
    
    out.println("내용 : <textarea name='contents' rows='5' cols='50'></textarea><br>");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body></html>");
  }
  
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=/lesson/list'>"
        + "</head>");
    out.println("<body><h1>수업 등록</h1>");
    try {
      Lesson lesson = new Lesson();
      lesson.setTitle(request.getParameter("title"));
      lesson.setContents(request.getParameter("contents"));
      lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
      
      lessonDao.insert(lesson);
      out.println("저장하였습니다.");
      
    } catch (Exception e) {
      out.println("데이터 저장에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }
  
  @RequestMapping("/lesson/delete") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void delete(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=/lesson/list'>"
        + "</head>");
    out.println("<body><h1>수업 삭제</h1>");
    try {

      int no = Integer.parseInt(request.getParameter("no"));
      
      if (lessonDao.delete(no) > 0) {
        out.println("삭제하였습니다.");
      } else {
        out.println("해당 데이터가 없습니다.");
      }
    } catch (Exception e) {
      out.println("데이터 삭제에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }

  @RequestMapping("/lesson/detail") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void detail(ServletRequest request, ServletResponse response) throws IOException {
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
      out.println("<form action='/lesson/update'>");
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
  
  @RequestMapping("/lesson/list") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void list(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 목록</title>"
        + "<link rel=\'stylesheet\' href=\'https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\' integrity=\'sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\' crossorigin=\'anonymous\'>"
        + "</head>");
    out.println("<body><h1>수업 목록</h1>");
    out.println("<a href='/lesson/form'>새 수업</a><br>");
    try {
      out.println("<table class='table'>");
      out.println("<tr><th>제목</th><th>내용</th><th>시작일</th><th>종료일</th><th>총시간</th></tr>");
      List<Lesson> lessons = lessonDao.findAll();
      for (Lesson lesson : lessons) {
        out.printf("<tr><td><a href='/lesson/detail?no=%d'>%s</td>"
            +"<td>%s</td><td>%s</td><td>%s</td><td>%d</td></tr>\n",
            lesson.getNo(), lesson.getTitle(), lesson.getContents(),
            lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
      }
      out.println("</table>");
    } catch (Exception e) {
      out.println("데이터 목록 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }
  
  @RequestMapping("/lesson/update") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다.
  public void update(ServletRequest request, ServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=/lesson/list'>"
        + "</head>");
    out.println("<body><h1>수업 변경</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Lesson lesson = lessonDao.findBy(no);
      if (lesson == null) {
        out.println("해당 번호의 데이터가 없습니다!");
        return;
      }

      // 사용자로부터 변경할 값을 입력 받는다.
      Lesson data = new Lesson();
      data.setNo(no);
      data.setTitle(request.getParameter("title"));
      data.setContents(request.getParameter("contents"));
      data.setStartDate(Date.valueOf(request.getParameter("startDate")));
      data.setEndDate(Date.valueOf(request.getParameter("endDate")));
      data.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
      data.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
      lessonDao.update(data);
      out.println("<p>데이터를 변경하였습니다.</p>");
      
    } catch (Exception e) {
      out.println("<p>데이터 변경에 실패했습니다!</p>");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }
}












