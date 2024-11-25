/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doubly_linked_list;

import java.util.NoSuchElementException;


class DoublyLinkedList<T> implements List<T>{
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void pushFront(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void pushBack(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T popFront() {
        if (head == null) throw new NoSuchElementException();
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return value;
    }

    @Override
    public T popBack() {
        if (tail == null) throw new NoSuchElementException();
        T value = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return value;
    }

    @Override
    public T find(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void erase(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                if (current == head) head = current.next;
                if (current == tail) tail = current.prev;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public void addBefore(T target, T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(target)) {
                Node<T> newNode = new Node<>(value);
                newNode.next = current;
                newNode.prev = current.prev;
                if (current.prev != null) current.prev.next = newNode;
                else head = newNode;
                current.prev = newNode;
                size++;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public void addAfter(T target, T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(target)) {
                Node<T> newNode = new Node<>(value);
                newNode.prev = current;
                newNode.next = current.next;
                if (current.next != null) current.next.prev = newNode;
                else tail = newNode;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public T topFront() {
        if (head == null) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public T topBack() {
        if (tail == null) throw new NoSuchElementException();
        return tail.value;
    }

    @Override
    public int size() {
        return size;
    }
}
