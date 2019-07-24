// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.CalcPlusCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.HiCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Input;

public class App {
  String name;
  static Scanner keyScan;
  public static void main(String[] args) throws Exception {
    
    keyScan = new Scanner(System.in);
    
    // 명령어를 저장하는 컬렉션(collection)
    // => java.util.Stack 에서는 Vector 클래스의 Iterator를 리턴한다.
    //    Vector에서 제공하는 Iterator는 입력한 순서대로 값을 꺼낸다.
    //    즉 FIFO 방식으로 꺼내기 때문에 스택의 LIFO 방식과 맞지 않다.
    //    그래서 ArrayDeque를 사용하는 것이다.
    //    ArrayDeque에서 제공하는 Iterator는 LIFO 방식으로 값을 꺼낸다.
    //    
    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();
    // Input.keyScan = keyScan;
    // Input 생성자를 통해 Input이 의존하는 객체인 Scanner를 주입한다.
    Input input = new Input(keyScan);
    
    // Command 객체를 보관할 Map 준비
    HashMap<String,Command> commandMap = new HashMap<>();
    
    // 각 핸들러의 생성자를 통해 의존 객체  "Input"을 주입한다.
    // => 이렇게 어떤 객체가 필요로 하는 의존 객체를 주입하는 것을
    // "의존성 주입(Dependency Injectrion; DI)" 라고 한다.
    // => DI를 전문적으로 처리해주는 프레임워크가 있으니 그 이름름도 유명한
    // Spring IoC 컨테이너!
    
    ArrayList<Lesson> lessonList = new ArrayList<>();
    ArrayList<Board> boardList = new ArrayList<>();
    LinkedList<Member> memberList = new LinkedList<>();
    
    commandMap.put("/lesson/add", new LessonAddCommand(input,lessonList));
    commandMap.put("/lesson/delete", new LessonDetailCommand(input,lessonList));
    commandMap.put("/lesson/detail", new LessonDeleteCommand(input,lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(input,lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(lessonList));
    
    commandMap.put("/board/add", new BoardAddCommand(input,boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(input,boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(input,boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(input,boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    
    commandMap.put("/member/add", new MemberAddCommand(input,memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(input,memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(input,memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(input,memberList));
    commandMap.put("/member/list", new MemberListCommand(memberList));
    commandMap.put("/hi", new HiCommand(input));
    commandMap.put("/calc/plus", new CalcPlusCommand(input));
    
    //LessonAddCommand leesonAddCommand = new LessonAddCommand(input,lessonList);
//    LessonDetailCommand leesonDetailCommand = new LessonDetailCommand(input,lessonList);
//    LessonDeleteCommand leesonDeleteCommand = new LessonDeleteCommand(input,lessonList);
//    LessonUpdateCommand lessonUpdateCommand = new LessonUpdateCommand(input,lessonList);
//    LessonListCommand lessonListCommand = new LessonListCommand(lessonList);
    
//    BoardAddCommand boardAddCommand = new BoardAddCommand(input, boardList);
//    BoardDeleteCommand boardDeleteCommand = new BoardDeleteCommand(input, boardList);
//    BoardDetailCommand baordDetailCommand = new BoardDetailCommand(input, boardList);
//    BoardUpdateCommand boardUpdateCommand = new BoardUpdateCommand(input, boardList);
//    BoardListCommand boardListCommnad = new BoardListCommand(boardList);
    
    
//    MemberAddCommand memberAddCommand = new MemberAddCommand(input, memberList);
//    MemberDeleteCommand memberDeleteCommand = new MemberDeleteCommand(input, memberList);
//    MemberDetailCommand memberDetailCommand = new MemberDetailCommand(input, memberList);
//    MemberUpdateCommand memberUpdateCommand = new MemberUpdateCommand(input, memberList);
//    MemberListCommand memberListCommand = new MemberListCommand(memberList);
    

    while(true) {
      String command = prompt();
      if(command.length()==0)
        continue;
      commandStack.push(command);
      commandQueue.offer(command);
      
      // 사용자가 입력한 명령어를 처리할 Command 객체를 Map에서 꺼낸다.
      Command executor = commandMap.get(command);
      
      if(command.equals("quit")){
        System.out.println("시스템을 종료합니다.");
        break;
        } else if (command.equals("history")) {
          printCommandHistory(commandStack);
        } else if (command.equals("history2")) {
          printCommandHistory(commandQueue);
        } else if(executor != null) {
          executor.execute();
        } else {
          System.out.println("해당 명령을 지원하지 않습니다!");
        } System.out.println();
      }
    }

    private static void printCommandHistory(Iterable<String> list) throws Exception{
      //Stack<String> stack = commandStack.clone();
      Iterator<String> iterator = list.iterator();
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        if(++count % 5 ==0) {
          System.out.print(":");
          if(keyScan.nextLine().equalsIgnoreCase("q"))
            break;
        }
      }
  }

    static String prompt() {
      System.out.print("명령> ");
      return keyScan.nextLine();
  }
}