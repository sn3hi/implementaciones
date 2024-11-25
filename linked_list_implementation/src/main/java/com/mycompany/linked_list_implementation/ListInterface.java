/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.linked_list_implementation;

/**
 *
 * @author snehi y diego
 */
interface ListInterface<T> {
       void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    T topFront();
    T topBack();
    void addBefore(T existingValue, T newValue);
    void addAfter(T existingValue, T newValue);
    void erase(T value);
    T find(T value);
    int size();
}
