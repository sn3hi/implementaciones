/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list_tail;

import java.util.LinkedList;

public class Queue<T> implements QueueInterface<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    @Override
    public void pushFront(T value) {
        list.addFirst(value);
    }

    @Override
    public void pushBack(T value) {
        list.addLast(value);
    }

    @Override
    public T popFront() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T popBack() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeLast();
    }

    @Override
    public T find(T value) {
        for (T item : list) {
            if (item.equals(value)) {
                return item;
            }
        }
        return null; // No encontrado
    }

    @Override
    public void erase(T value) {
        list.remove(value);
    }

    @Override
    public void addBefore(T target, T value) {
        int index = list.indexOf(target);
        if (index == -1) {
            throw new IllegalArgumentException("Target not found");
        }
        list.add(index, value);
    }

    @Override
    public void addAfter(T target, T value) {
        int index = list.indexOf(target);
        if (index == -1) {
            throw new IllegalArgumentException("Target not found");
        }
        list.add(index + 1, value);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T topFront() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    @Override
    public T topBack() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getLast();
    }
}