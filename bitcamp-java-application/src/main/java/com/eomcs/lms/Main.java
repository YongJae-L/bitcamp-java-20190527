package com.eomcs.lms;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int numbers[] = {1, 1, 1, 1, 1};
    int target = 3;
    System.out.println(solution.solution(numbers, target));
  }

}

class Solution {
  public int solution(int[] numbers, int target) {
      return recursion(numbers,target,0,0);
  }

  private int recursion(int[] numbers, int target, int i, int num) {
    if(i == numbers.length) {
      return target == num ? 1: 0;
    } else {
      return recursion(numbers,target,i+1,num+numbers[i])
          +recursion(numbers,target,i+1,num-numbers[i]);
    }
  }
}