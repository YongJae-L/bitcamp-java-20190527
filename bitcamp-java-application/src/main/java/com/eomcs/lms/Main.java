package com.eomcs.lms;

import java.util.Scanner;

public class Main {
  static int [][] arr;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    arr = new int[num][num];
    sc.nextLine();
    for(int i=0;i<num;i++) {
      String temp = sc.nextLine();
      for(int j=0;j<num;j++) {
        arr[i][j]=Integer.parseInt(temp.substring(j, j+1));
      }
    }
    for(int i=0;i<num;i++) {
      for(int j=0;j<num;j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
    
    
    
    
    sc.close();
  }

}
