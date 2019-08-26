package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Long> stack = new Stack<>();
    
    stack.push(Long.parseLong(st.nextToken()));
    bw.append("0");
    int max = 1;
    for(int i=1;i<N;i++) {
      long now = Long.parseLong(st.nextToken());
      while(!stack.isEmpty()) {
        if(now<stack.peek()) {
          max=i;
          bw.append(" "+max);
          stack.push(now);
          break;
        } else {
          stack.pop();
          max--;
        }
      }
      if(stack.isEmpty()) {
        System.out.println("ㅇㅇ");
        bw.write(" 0");
        max=i+1;
      }
      stack.push(now);
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
