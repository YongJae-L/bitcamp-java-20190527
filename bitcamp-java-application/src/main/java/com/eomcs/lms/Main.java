package com.eomcs.lms;

public class Main {
  public static void main(String[] args) {

    int [] answers = {1,3,2,4,2};
    System.out.println(solution(answers));

  }

  private static int[] solution(int[] answers) {
    int[] answer1 = {1,2,3,4,5};
    int[] answer2 = {2,1,2,3,2,4,2,5};
    int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
    int a=0,b=0,c=0;
    for(int i=0;i<40;i++){
      if(answers[i%5] == answer1[i%5]){
        a++;
      }
      if (answers[i%5] == answer2[i%8]) {
        b++;
      }
      if (answers[i%5] == answer3[i%10]) {
        c++;
      }
    }
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    
    if(a==b && b==c) {
      int[] arr = {1,2,3};
      return arr; 
    } else if (a==b && a>c) {
      int[] arr = {1,2};
      return arr;
    } else if (b==c && b>a) {
      int[] arr = {2,3};
      return arr;
    } else if (a==c && a>b) {
      int[] arr = {1,3};
      return arr;
    } else {
      int temp = Math.max(Math.max(a, b), c);
      if(temp == a) {
        int[] arr = {1};
        return arr;
      } else if (temp == b) {
        int[] arr = {2};
        return arr;
      } else {
        int[] arr = {3};
        return arr;
      }
    }
  }
}