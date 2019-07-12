package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.Input;

public class LessonHandler {
  private Lesson[] lessons = new Lesson[100];
  private int leesonsSize=0;
  private Input input;
  
  public LessonHandler(Input input){
    this.input=input;
  }
  
  public void addLesson() {
    Lesson lesson = new Lesson();
    
    lesson.setNo(input.getIntValue("번호? "));
    lesson.setTitle(input.getStringValue("수업명? "));
    lesson.setContents(input.getStringValue("설명? "));
    lesson.setStartDate(input.getDateValue("시작일? "));
    lesson.setEndDate(input.getDateValue("종료일? "));
    lesson.setTotalHours(input.getIntValue("총수업시간? "));
    lesson.setDayHours(input.getIntValue("일수업시간? "));
    
    lessons[leesonsSize++] = lesson;
    System.out.println("저장하였습니다.");
  }
  
  public void listLesson() {
    if(leesonsSize==0)
      System.out.println("해당 리스트가 존재하지 않습니다.");
    for ( int i2 = 0; i2 < leesonsSize; i2++) {
      Lesson lesson = lessons[i2];
      System.out.printf("%s, %s, %s ~ %s, %s\n",
          lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

}
