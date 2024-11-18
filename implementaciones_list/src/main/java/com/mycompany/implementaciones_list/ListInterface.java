
package com.mycompany.implementaciones_list;


public interface ListInterface<T> {
    void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    boolean find(T value);
    boolean erase(T value);
    void addBefore(T target, T value);
    void addAfter(T target, T value);
    boolean isEmpty();
    int size();
    T topFront();
    T topBack();
}