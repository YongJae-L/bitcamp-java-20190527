package com.eomcs.util;

import java.util.Arrays;

public class ArrayList {
  private static final int DEFAULT_CAPACITY=100;
  private Object[] list;
  private int size=0;
  
  public ArrayList() {
    //list = new Board[100];
    this(DEFAULT_CAPACITY); //다른 생성자를 가리키는 특수한 문법
  }
  
  public ArrayList(int initialCapacity) {
    if(initialCapacity < 50 || initialCapacity >10000)
      list = new Object[DEFAULT_CAPACITY];
    else
      list = new Object[initialCapacity];
  }

  public void add(Object obj) { 
    if( this.size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); // >> 1 은 2로 나누는 것과 같다.
      list = Arrays.copyOf(this.list, newCapacity); //1.복사할 배열, 2.새로만들 배열의 크기 지정 배열크기만큼 복사 후 2가 더 크면 빈배열을 늘림
    }
    this.list[size++] =obj;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size); //0번째부터 size까지 복사해서 새 배열을 리턴한다.
    
//    Object[] arr = new Object[this.size];
//    for(int i=0;i<this.size;i++) {
//      arr[i] = this.list[i];
//    }
//    return arr;
  }
  
  
}
