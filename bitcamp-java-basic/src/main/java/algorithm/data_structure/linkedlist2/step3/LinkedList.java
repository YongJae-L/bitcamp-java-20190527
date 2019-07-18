// LinkedList : 목록으로 다루는 값을 특정 타입으로 제한하기 위해 제네릭(generic) 적용하기
package algorithm.data_structure.linkedlist2.step3;

import java.lang.reflect.Array;

public class LinkedList<T> {
  Node<T> head;
  Node<T> tail;
  int size = 0;
  
  public LinkedList() {
    //head = new Node(); //빈노드생성
    //tail = head; //head 변수에 들어있는 '값'을 tail의 변수에 값을 저장 L-value는 메모리/ R-value는 값
  }
  
  public boolean add(T value) {
    Node<T> temp = new Node<>(value);
    
    if(head == null)
      head = temp;
    if(tail != null)
      tail.next = temp;
    tail = temp;
    
    
//    tail.value = value;
//    tail.next = new Node();
//    tail=tail.next;
    size++;
    return true;
  }
  
  public T get(int index) {
    if(index < 0 || index >=size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");
    Node<T> node = head;
    for(int i=0;i< index;i++) {
      node = node.next;
    }
    return node.value;
    
  }
  
  public int size() {
    return size;
  }
  
  public T set(int index, T value) {
    if(index < 0 || index >=size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");
    Node<T> node = head;
    for(int i=0;i< index;i++) {
      node = node.next;
    }
    T oldvalue = node.value;
    node.value=value;
    return oldvalue;
  }
  
  public T remove(int index) {
    if(index < 0 || index >=size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");

    Node<T> deletedNode = null;
    if(index==0) {
      deletedNode = head;
      head=deletedNode.next;
      T oldVal = deletedNode.value;
      deletedNode.value = null;
      deletedNode.next = null;
      size--;
      return oldVal;
    } else {
    Node<T> node = head;
    
    for(int i=0;i< index-1;i++) {
      node = node.next;
    }
//    if(index==this.size-1) {
//      deletedNode = node.next;
//      Object oldVal = deletedNode.value;
//      deletedNode.value = null;
//      deletedNode.next = null;
//      node = node.next;
//      this.tail=node.next;
//      size--;
//      return oldVal;
//    }
      
      deletedNode = node.next;
      node.next = deletedNode.next;
      
      if(deletedNode == tail) {
        tail = node;
      }
      
      T oldVal = deletedNode.value;
      deletedNode.value = null;
      deletedNode.next = null;
      size--;
      return oldVal;
    }
  }
  
  public void clear() {
    //노드를 따라 가면서 삭제하기
    if(size==0)
      return;
    // 노드를 따라 가면서 삭제하기
    while(head != null) {
      Node<T> deletedNode = head;
      head = head.next;
      deletedNode.next=null;
      deletedNode.value=null;
    }
    tail = null;
    size = 0;
  }
  
//  public Object[] toArray() {
//    // LinkedList에 있는 데이터를 저장할 배열을 준비한다.
//    Object[] arr = new Object[size];
//    // LinkedList의 head에서 tail까지 반복하면서 배열에 value를 복사한다.
//    Node node = head;
//    for(int i=0;i< size;i++) {
//      arr[i] = node.value;
//      node = node.next;
//    }
//    // 배열을 리턴한다.
//    return arr;
//    
//  }
  
  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    if(a.length<size) {
      // 파라미터로 넘겨 받은 배열의 크기가 저장된 데이터의 개수 보다 작다면
      // 이 메서드에서 새 배열을 만든다.
      a =(T[]) Array.newInstance(a.getClass().getComponentType(),size);
    }
    Node<T> node = head;
    for(int i=0;i< size;i++) {
      a[i] = node.value;
      node = node.next;
    }
    if(a.length>size)
      a[size]=null;
    return a;
  }
  
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.add("7");
    list.set(2, "222");
//    for (int i=0;i<list.size;i++) {
//      System.out.println(list.get(i));
//    }
//    System.out.println(list.size);
      
      String[] arr = list.toArray(new String[] {});
      for (String obj : arr) {
        System.out.println(obj);
      }
//    for(Object arr : list.toArray()) {
//      System.out.println(arr);
//    }
    
  }
  // LinkedList에서 사용하는 클래스라면 굳이 패키지 멤버 클래스로 만든 필요가 없다.
  // LinkedList 안에 선언하여 중첩 클래스로 정의하는 것이
  // 소스 코드의 유지보수에 좋다.
  
  // Node 객체에 보관하는 데이터의 타입을 T 타입 파라미터로 받는다.
  static class Node<T> {
    T value;
    Node<T> next;
    
    public Node() {
    }
    
    public Node(T value) {
      this.value=value;
    }
  }
}









