package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br.readLine();
    StringTokenizer st = new StringTokenizer(br.readLine());
    while(st.hasMoreElements()) {
      al.add(Long.parseLong(st.nextToken()));
    }

    for(int i=0;i<al.size();i++) {
      boolean b = true;
      int n=i;
      while(n-->0) {
        if(al.get(n)>al.get(i)) {
          bw.write(n+1+" ");
          b=false;
          break;
        }
      }
      if(b)
        bw.write(0+" ");
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
