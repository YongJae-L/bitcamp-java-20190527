package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Component;
import com.eomcs.util.Input;
import com.eomcs.util.RequestMapping;

@Component("/lesson/update")
public class LessonUpdateCommand {

  private LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  
  @RequestMapping
  public void execute(BufferedReader in, PrintStream out) {

    try {
      int no = Input.getIntValue(in, out, "번호? ");

      Lesson lesson1 = lessonDao.findBy(no);
      if (lesson1 == null) {
        out.println("해당 번호의 데이터가 없습니다!");
        return;
      }
      Lesson lesson = new Lesson();
      lesson.setNo(no);
      // 사용자로부터 변경할 값을 입력 받는다.
      String str = Input.getStringValue(in, out, "수업명? ");
      if (str.length() > 0) {
        lesson.setTitle(str);
      }

      str = Input.getStringValue(in, out, "수업내용? ");
      if (str.length() > 0) {
        lesson.setContents(str);
      }

      lesson.setStartDate(Input.getDateValue(in, out, "시작일? "));
      lesson.setEndDate(Input.getDateValue(in, out, "종료일? "));
      lesson.setTotalHours(Input.getIntValue(in, out, "총수업시간? "));
      lesson.setDayHours(Input.getIntValue(in, out, "총수업시간? "));

      lessonDao.update(lesson);

      out.println("데이터를 변경했습니다.");
    } catch (Exception e) {
      out.println("데이터 변경 실패!!!!");
      System.out.println(e.getMessage());
    }
  }

}
