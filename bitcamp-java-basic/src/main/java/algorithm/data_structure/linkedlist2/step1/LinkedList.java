package algorithm.data_structure.linkedlist2.step1;

public class LinkedList {
  Node head;
  Node tail;
  int size = 0;
  
  public LinkedList() {
    //head = new Node(); //빈노드생성
    //tail = head; //head 변수에 들어있는 '값'을 tail의 변수에 값을 저장 L-value는 메모리/ R-value는 값
  }
  
  public boolean add(Object value) {
    Node temp = new Node(value);
    
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
  
  public Object get(int index) {
    if(index < 0 || index >=size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");
    Node node = head;
    for(int i=0;i< index;i++) {
      node = node.next;
    }
    return node.value;
    
  }
  
  public int size() {
    return size;
  }
  
  public Object set(int index, Object value) {
    if(index < 0 || index >=size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");
    Node node = head;
    for(int i=0;i< index;i++) {
      node = node.next;
    }
    Object oldvalue = node.value;
    node.value=value;
    return oldvalue;
  }
  
  public Object remove(int index) {
    if(index < 0 || index >=size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");

    Node deletedNode = null;
    if(index==0) {
      deletedNode = head;
      head=deletedNode.next;
      Object oldVal = deletedNode.value;
      deletedNode.value = null;
      deletedNode.next = null;
      size--;
      return oldVal;
    } else {
    Node node = head;
    
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
      
      Object oldVal = deletedNode.value;
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
      Node deletedNode = head;
      head = head.next;
      deletedNode.next=null;
      deletedNode.value=null;
    }
    tail = null;
    size = 0;
  }
  
  public Object[] toArray() {
    // LinkedList에 있는 데이터를 저장할 배열을 준비한다.
    Object[] arr = new Object[size];
    // LinkedList의 head에서 tail까지 반복하면서 배열에 value를 복사한다.
    Node node = head;
    for(int i=0;i< size;i++) {
      arr[i] = node.value;
      node = node.next;
    }
    // 배열을 리턴한다.
    return arr;
    
  }
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.set(2, 222);
//    for (int i=0;i<list.size;i++) {
//      System.out.println(list.get(i));
//    }
//    System.out.println(list.size);
    
    for(Object arr : list.toArray()) {
      System.out.println(arr);
    }
    
  }
}
