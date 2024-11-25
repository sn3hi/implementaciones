/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list_implementation;
 public class LinkedList<T> implements ListInterface<T> {
    private Node<T> first; // Nodo inicial
    private int count;     // Cantidad de elementos

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    @Override
    public void pushFront(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = first;
        first = newNode;
        count++;
    }

    @Override
    public void pushBack(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }

    @Override
    public T popFront() {
        if (first == null) throw new IllegalStateException("List is empty");
        T data = first.data;
        first = first.next;
        count--;
        return data;
    }

    @Override
    public T popBack() {
        if (first == null) throw new IllegalStateException("List is empty");
        if (first.next == null) {
            T data = first.data;
            first = null;
            count--;
            return data;
        }
        Node<T> current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        count--;
        return data;
    }

    @Override
    public T topFront() {
        if (first == null) throw new IllegalStateException("List is empty");
        return first.data;
    }

    @Override
    public T topBack() {
        if (first == null) throw new IllegalStateException("List is empty");
        Node<T> current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void addBefore(T existingValue, T newValue) {
        if (first == null) throw new IllegalStateException("List is empty");
        if (first.data.equals(existingValue)) {
            pushFront(newValue);
            return;
        }
        Node<T> current = first;
        while (current.next != null && !current.next.data.equals(existingValue)) {
            current = current.next;
        }
        if (current.next == null) throw new IllegalArgumentException("Value not found");
        Node<T> newNode = new Node<>(newValue);
        newNode.next = current.next;
        current.next = newNode;
        count++;
    }

    @Override
    public void addAfter(T existingValue, T newValue) {
        Node<T> current = first;
        while (current != null && !current.data.equals(existingValue)) {
            current = current.next;
        }
        if (current == null) throw new IllegalArgumentException("Value not found");
        Node<T> newNode = new Node<>(newValue);
        newNode.next = current.next;
        current.next = newNode;
        count++;
    }

    @Override
    public void erase(T value) {
        if (first == null) throw new IllegalStateException("List is empty");
        if (first.data.equals(value)) {
            first = first.next;
            count--;
            return;
        }
        Node<T> current = first;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }
        if (current.next == null) throw new IllegalArgumentException("Value not found");
        current.next = current.next.next;
        count--;
    }

    @Override
    public T find(T value) {
        Node<T> current = first;
        while (current != null) {
            if (current.data.equals(value)) return current.data;
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}