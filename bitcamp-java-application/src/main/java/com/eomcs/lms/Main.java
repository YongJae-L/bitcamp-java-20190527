package com.eomcs.lms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    String [][] clothes = {{"1","A"},{"2","B"},{"3","A"}};
    System.out.println(clothes.length);
    Solution solution = new Solution();
    System.out.println(solution.solution(clothes));
  }
}
class Solution {
  public int solution(String[][] clothes) {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<Integer> al = new ArrayList<>();
    for(int i=0;i<clothes.length;i++){
      map.put(clothes[i][1],0);
    }
    for(int i=0;i<clothes.length;i++){
      map.put(clothes[i][1],map.get(clothes[i][1])+1);
    }
    Set set = map.keySet();
    Iterator iterator = set.iterator();
    while(!iterator.hasNext()) {
      al.add(map.get(iterator.next()));
    }
    return al.size();
  }
}
