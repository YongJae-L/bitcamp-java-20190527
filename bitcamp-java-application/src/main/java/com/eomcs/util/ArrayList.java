package com.eomcs.util;

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
    if( this.size == list.length)
      throw new RuntimeException("배열이 꽉 찼습니다!");
    this.list[size++] =obj;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    for(int i=0;i<this.size;i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
  
  
}
