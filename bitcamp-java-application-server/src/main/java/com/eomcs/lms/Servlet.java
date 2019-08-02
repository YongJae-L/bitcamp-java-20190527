package com.eomcs.lms;

// 클라이언트로부터 요청을 받았을 때 SErverApp에서 해당 요청을 처리하기 위해
// 담당자를 호출하는 규칙
public interface Servlet {
  void service(String command) throws Exception; //들어오는 데이터는 읽기 쉽도록 Object인풋스트림
}
