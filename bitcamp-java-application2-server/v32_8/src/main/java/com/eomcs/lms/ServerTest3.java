package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class ServerTest3 {
  static ObjectOutputStream out;
  static ObjectInputStream in;
  public static void main(String[] args) throws Exception {
    System.out.println("[수업관리시스템 서버 애플리케이션 테스트]");
    
    try (Socket socket = new Socket("localhost",8888);
        // 서버와의 입출력을 위해 스트림 객체를 준비한다.
        // => 버퍼를 사용할 경우, 데이터를 보내는 쪽에서는 출력 스트림을 먼저 준비하라!
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      
      System.out.println("서버와 연결되었음.");
      ServerTest3.in=in;
      ServerTest3.out=out;
      
      Board Board = new Board();
      Board.setNo(1);
      Board.setContents("제목1");
      
      if(!add(Board)) {
        error();
      }
        
      System.out.println("-----------------");
      Board = new Board();
      Board.setNo(2);
      Board.setContents("제목2");
      if(!add(Board)) {
        error();
      }
      System.out.println("-----------------");
      if(!list()) {
        error();
      }
      System.out.println("-----------------");
      if(!delete()) {
        error();
      }
      System.out.println("-----------------");
      if(!list()) {
        error();
      }
      System.out.println("-----------------");
      if(!detail()) {
        error();
      }
      Board = new Board();
      Board.setNo(1);
      Board.setContents("오호라~!~!!");
      System.out.println("-----------------");
      if(!update(Board)) {
        error();
      }
      System.out.println("-----------------");
      if(!list()) {
        error();
      }
      System.out.println("-----------------");
      if(!quit()) {
        error();
      }
    } catch (RequestException e) {
      // 서버에서 요청 처리에 실패했다면
      // 서버가 보낸 이유를 받는다.
      System.out.printf("오류: %s\n", in.readUTF());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("서버와 연결 끊음");
  }
  
  private static boolean update(Board obj) throws Exception {
    out.writeUTF("/board/update");
    out.writeObject(obj);
    out.flush();
    System.out.println("detail 요청함 ===>");
    if(!in.readUTF().equals("ok"))
      return false;
    
    System.out.println("처리 완료!");
    return true;
  }

  private static boolean detail() throws Exception {
    out.writeUTF("/board/detail");
    out.writeInt(1);
    out.flush();
    System.out.println("detail 요청함 ===>");
    if(!in.readUTF().equals("ok"))
      return false;
    System.out.println("처리 완료!");
    System.out.println(in.readObject());
    return true;
  }

  private static void error() throws Exception {
    System.out.printf("오류: %s\n", in.readUTF());
  }

  private static boolean quit() throws Exception {
    out.writeUTF("quit");
    out.flush();
    System.out.println("quit요청함 => ");
    
    if (!in.readUTF().equals("ok"))
      return false;
    System.out.println("처리 완료!");
      return true;
  }

  private static boolean delete() throws Exception {
    // 서버가 처리할 수 없는 명령어 보내기
    out.writeUTF("/board/delete");
    out.writeInt(2);
    out.flush();
    System.out.println("delete요청함 =>");
    
    if (!in.readUTF().equals("ok"))
      return false;
    
    System.out.println("처리 완료!");
    return true;
    
  }

  private static boolean add(Board obj) throws IOException, RequestException {
    
    out.writeUTF("/board/add");
    out.writeObject(obj);
    out.flush();
    System.out.print("add 요청함 => ");
    
    if (!in.readUTF().equals("ok"))
      return false;
    
    System.out.println("처리 완료!");
    return true;
  }
  
  private static boolean list() throws Exception {
    out.writeUTF("/board/list");
    out.flush();
    System.out.println("list 요청함");
    if (!in.readUTF().equals("ok"))
      return false;
    
    System.out.println("처리 완료!");
    
    @SuppressWarnings("unchecked")
    List<Board> list = (List<Board>)in.readObject();
    System.out.println("-----------------");
    System.out.println("@@@@@@@!:"+list.size());
    for(Board obj : list) {
      System.out.println(obj);
    }
    return true;
  }
}
