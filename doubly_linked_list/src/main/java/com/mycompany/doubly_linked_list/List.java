/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.doubly_linked_list;

interface List<T> {
    void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    T find(T value);
    void erase(T value);
    void addBefore(T target, T value);
    void addAfter(T target, T value);
    T topFront();
    T topBack();
    int size();
}
