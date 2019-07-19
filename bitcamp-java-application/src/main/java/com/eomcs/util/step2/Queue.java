// 상속 문법을 이용하여 스택 만들기
package com.eomcs.util.step2;

import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;

public class Queue<E> extends LinkedList<E> implements Cloneable {
  
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    //현재 큐 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행한다.
    // => 새 큐을 만들고,
    Queue<E> temp = new Queue<>();
    for (int i=0;i<size();i++) {
      // => 현재 큐에서 값을 꺼내 새 큐의 새 노드에 넣는다.
      //    즉 새 큐의 값을 넣을 때 마다 새 노드를 생성하기 때문에
      //    현재 큐의 노드에는 영향을 끼치지 않는다.
      temp.offer(get(i));
      
    }
    
    return temp;
    //return (Stack<E>) super.clone();
  }
  
  public void offer(E value) {
    add(value);
  }
  
  public E poll() {
    return remove(0);
  }
  
  public boolean empty() {
    return size() == 0;
  }
  
  // 큐의 데이터를 꺼내줄 Iterator를 제공한다.
  public Iterator<E> createIterator() {
  //  Queue<E> clonedQueue = this; // 복제된 commandQueue의 주소가 들어 있다.
  //  QueueIterator<E> iterator = new QueueIterator<>(clonedQueue);
  //  return iterator;
    return new QueueIterator();
  }
  
  //큐에 있는 데이터를 꺼내주는 역할을 한다.
  //Iterator 규칙에 따라 작성하여 
  //이 객체를 사용하는 개발자가 일관된 방식으로 호출할 수 있게 한다.
  
  // => 이 클래스에서 사용할 클래스는 이 클래스 안에 선언하는 것이 소스 코드 관리에 좋다.
  //    이렇게 클래스 안에 선언된 클래스를 newsted class (중첩 클래스) 라 부른다.
  //    중첩 클래스 중에서 static 이 안 붙은 중첩 클래스를 "non-static newsted class" 라 부른다.
  // => 중첩 클래스의 가장 큰 효용성은 다른 멤버(메서드)들 처럼 다른 멤버를 그냥 사용할 수 있다는 것이다.
  
private class QueueIterator implements Iterator<E>{
// Queue<E> queue;
// public QueueIterator(Queue<E> queue) {
//   this.queue = queue;
// }
 @Override
 public boolean hasNext() {
   //return queue.size() > 0;
   return size() > 0;
 }

 @Override
 public E next() {
   //return queue.poll();
   return poll();
 }

}

}