package com.eomcs.util;

public interface List<E> {

  boolean add(E value);
  E get(int index);
  int size();
  E set(int index, E value);
  E remove(int index);
  E[] toArray(E[] a);
  Object[] toArray();
  void clear();
}
