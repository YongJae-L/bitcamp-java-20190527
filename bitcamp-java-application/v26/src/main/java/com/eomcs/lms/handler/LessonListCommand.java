package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  
  private List<Lesson> list;
  
  public LessonListCommand(List<Lesson> list ){
    this.list = list;
  }
  @Override
  public void execute() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {      
      System.out.printf("%s, %s, %s ~ %s, %s\n",
          lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

}
