package com.eomcs.lms;

public class LessonHandler {
  static Lesson[] lessons = new Lesson[100];
  static int leesonsSize=0;
  
  static void addLesson() {
    Lesson lesson = new Lesson();
    
    lesson.no = Input.getIntValue("번호? ");
    lesson.title = Input.getStringValue("수업명? ");
    lesson.contents = Input.getStringValue("설명? ");
    lesson.startDate= Input.getDateValue("시작일? ");
    lesson.endDate = Input.getDateValue("종료일? ");
    lesson.totalHours = Input.getIntValue("총수업시간? ");
    lesson.dayHours = Input.getIntValue("일수업시간? ");
    
    lessons[leesonsSize++] = lesson;
    System.out.println("저장하였습니다.");
  }
  
  static void listLesson() {
    if(leesonsSize==0)
      System.out.println("해당 리스트가 존재하지 않습니다.");
    for ( int i2 = 0; i2 < leesonsSize; i2++) {
      Lesson lesson = lessons[i2];
      System.out.printf("%s, %s, %s ~ %s, %s\n",
          lesson.no, lesson.title, lesson.startDate, lesson.endDate, lesson.totalHours);
    }
  }

}
