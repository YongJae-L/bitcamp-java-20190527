package com.eomcs.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {7,4,5,6};
    System.out.println(solution.solution(2,10,arr));
  }

}

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> Q = new LinkedList<>();
    ArrayList<Integer> al = new ArrayList<>();
    HashMap<Integer,Integer> hash = new HashMap<>();
    int count=0;
    int now_weight=0;
    for(Integer w : truck_weights)
      Q.add(w);
    //al.add(Q.peek());
    while(!al.isEmpty()) {
      if(now_weight+Q.peek()<=weight) {
        al.add(Q.peek());
        hash.put(Q.peek(), hash.getOrDefault(Q.peek(),1)+1);
        now_weight+=Q.remove();
      } else {
        
      }
     for(int i=0;i<al.size();i++) {
       hash.put(al.get(i),hash.getOrDefault(Q.peek(),1)+1);
     }
     if(hash.get(al.get(0))==bridge_length) {
       now_weight-=al.remove(0);
     }
     count++;
    }
    return count;
  }
}