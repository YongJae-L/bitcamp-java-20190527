package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  
  private LessonDao lessonDao;
  
  public LessonListCommand(LessonDao lessonDao){
    this.lessonDao = lessonDao;
  }
  @Override
  public void execute() {
    List<Lesson> lessons;
    try {
      lessons = lessonDao.findAll();
      for (Lesson lesson : lessons) {      
        System.out.printf("%s, %s, %s ~ %s, %s\n",
            lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
      }
    } catch (Exception e) {
      System.out.println("데이터 목록 조회에 실패 했습니다.");
      e.printStackTrace();
    }
  }

}
