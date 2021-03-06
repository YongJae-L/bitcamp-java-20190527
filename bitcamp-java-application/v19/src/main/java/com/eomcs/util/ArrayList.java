package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> { //Type 파라미터 //타입을 변수로 받아서 사용 제네릭 -->add(dataType obj)
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

  public void add(E obj) { 
    if( this.size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); // >> 1 은 2로 나누는 것과 같다.
      list = Arrays.copyOf(list, newCapacity); //1.복사할 배열, 2.새로만들 배열의 크기 지정 배열크기만큼 복사 후 2가 더 크면 빈배열을 늘림
    }
    this.list[size++] =obj;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(list, size); //0번째부터 size까지 복사해서 새 배열을 리턴한다.
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if(a.length < size) {
      //파라미터로 넘겨 받은 배열의 크기가 저장된 데이터의 개수 보다 작다면
      // 이 메서드에서 새 배열을 만든다.
    return (E[])Arrays.copyOf(list, size, a.getClass()); // new Object[this.size] 를 만든다. 여기서 타입을 지정하면 그 타입의 배열이 만들어진다.
    }
    System.arraycopy(this.list, 0, a, 0, size);
    if(a.length > size)
      a[size] = null;
    return a;
  }
  public int size() {
    return this.size;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if(index <0 || index >= size)
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    return (E) list[index];
  }
  
  public E remove(int index) {
    if(index <0 || index >= size)
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    @SuppressWarnings("unchecked")
    E old = (E) list[index];
    
//      for(int i=index+1;i<size();i++) {
//        list[i-1] = list[i];
//      }
      //size--;
    System.arraycopy(list, index+1, list, index, size -(index+1));
    list[--size] =null;
    return old;
  }
  
  public E set(int index, E obj) {
    if(index <0 || index >= size)
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    
    @SuppressWarnings("unchecked")
    E old = (E) list[index];
    list[index]=obj;
    
    return old;
    
  }
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    
    list.set(1, "3");
    list.remove(2);
    for(int i=0;i<list.size;i++) {
      System.out.println(list.get(i));
    }
    
  }
}
