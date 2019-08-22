package com.eomcs.lms;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient01 {

  String host;
  int port;

  public ChatClient01(String host, int port) {
    this.host = host;
    this.port = port;
  }

  private void service() {
    try (Socket socket = new Socket(host, port);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner keyboard = new Scanner(System.in)) {

      System.out.println("접속하셨습니다. 나가려면 quit 입력해주세요.");

      new Thread(new MessageReceiver(in)).start();

      while (true) {
        System.out.print(">>");
        String message = keyboard.nextLine();

        if (message.equals("quit")) {
          out.println(message);
          out.flush();
          break;
        }

        out.println(message);
        out.flush();

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
        }
      }
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("실행방법: java -Dfile.encoding=UTF-8 -cp bin/main test.ChatClient 서버주소 포트번호");
      return;
    }

    ChatClient01 app = new ChatClient01(args[0], Integer.parseInt(args[1]));
    app.service();
  }

}
