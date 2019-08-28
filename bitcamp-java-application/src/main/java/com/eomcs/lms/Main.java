package com.eomcs.lms;

import java.io.IOException;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    String [] phone_book = {"119","97674223","1195524421"};
    Solution solution = new Solution();
    System.out.println(solution.solution(phone_book));
  }
}
class Solution {
  public boolean solution(String[] phone_book) {
    for(int i=0;i<phone_book.length;i++) {
      for(int j=0;j<phone_book.length;j++) {
        if(i != j && phone_book[i].startsWith(phone_book[j])) return false;
      }
    }
    return true;
  }
}
