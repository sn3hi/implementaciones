/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list_tail;

public interface QueueInterface<T> {
      void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    T find(T value);
    void erase(T value);
    void addBefore(T target, T value);
    void addAfter(T target, T value);
    int size();
    T topFront();
    T topBack();
}