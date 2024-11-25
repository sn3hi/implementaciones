/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doubly_linked_list;

/**
 *
 * @author snehi y diego
 */
public class Doubly_linked_list {

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};

        for (int size : sizes) {
            System.out.println("Testing size: " + size);

            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            // Medir el tiempo de pushFront
            long start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.pushFront(i);
            }
            long end = System.nanoTime();
            System.out.println("pushFront time: " + (end - start) + " ns");

            // Medir el tiempo de pushBack
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.pushBack(i);
            }
            end = System.nanoTime();
            System.out.println("pushBack time: " + (end - start) + " ns");

            // Medir el tiempo de popFront
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.popFront();
            }
            end = System.nanoTime();
            System.out.println("popFront time: " + (end - start) + " ns");

            // Medir el tiempo de popBack
            for (int i = 0; i < size; i++) {
                list.pushBack(i);
            }
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.popBack();
            }
            end = System.nanoTime();
            System.out.println("popBack time: " + (end - start) + " ns");

            // Medir el tiempo de find
            for (int i = 0; i < size; i++) {
                list.pushBack(i);
            }
            start = System.nanoTime();
            list.find(size / 2);
            end = System.nanoTime();
            System.out.println("find time: " + (end - start) + " ns");

            // Medir el tiempo de erase
            start = System.nanoTime();
            list.erase(size / 2);
            end = System.nanoTime();
            System.out.println("erase time: " + (end - start) + " ns");

            // Medir el tiempo de addBefore
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.addBefore(i, -i);
            }
            end = System.nanoTime();
            System.out.println("addBefore time: " + (end - start) + " ns");

            // Medir el tiempo de addAfter
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.addAfter(i, -i);
            }
            end = System.nanoTime();
            System.out.println("addAfter time: " + (end - start) + " ns");

            // Medir el tiempo de size
            start = System.nanoTime();
            int currentSize = list.size();
            end = System.nanoTime();
            System.out.println("size time: " + (end - start) + " ns");

            // Medir el tiempo de topFront
            start = System.nanoTime();
            Integer front = list.topFront();
            end = System.nanoTime();
            System.out.println("topFront time: " + (end - start) + " ns");

            // Medir el tiempo de topBack
            start = System.nanoTime();
            Integer back = list.topBack();
            end = System.nanoTime();
            System.out.println("topBack time: " + (end - start) + " ns");

            System.out.println("----------------------------------");
        }
    }
}
