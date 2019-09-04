package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
  
  String name;
  String host;
  int port;

  public Main(String host, int port) {
    this.host = host;
    this.port = port;
  }

  private void service() {
    try (Socket socket = new Socket(host, port);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner keyboard = new Scanner(System.in)) {
      
      new Thread(new MessageReceiver(in)).start();
      
      // 닉네임 입력하기
      this.name = keyboard.nextLine();
      out.println(name);
      out.flush();
      
      String message = "";
      
      while (!message.equals("quit")) {
        System.out.print(">>");
        message = keyboard.nextLine();
        
        if (message.length() != 0) {
          out.println(message);
          out.flush();
          
//          if (message.equals("quit"))
//            break;
          
        }

      }
      System.out.println("서버와 연결 끊음");
      System.exit(0);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public class MessageReceiver implements Runnable {

    BufferedReader in;

    public MessageReceiver(BufferedReader in) {
      this.in = in;
    }

    @Override
    public void run() {
      while (true) {
        try {
          String message = in.readLine();
          System.out.println(message);
        } catch (Exception e) {
          System.out.println("메시지 수신 중 오류 발생!");
          System.out.println("서버가 통신을 끊음");
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
//    if (args.length != 2) {
//      System.out.println("실행방법: java -Dfile.encoding=UTF-8 -cp bin/main test.ChatClient 서버주소 포트번호");
//      return;
//    }

    Main app = new Main("192.168.0.22", 9999);
    app.service();
  }

}