/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.linked_list_tail;

/**
 *
 * @author snehi y diego
 */
public class Linked_list_tail {

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};

        for (int size : sizes) {
            System.out.println("Testing size: " + size);

            Queue<Integer> list = new Queue<>();

            long start, end;

            // pushFront
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.pushFront(i);
            }
            end = System.nanoTime();
            System.out.println("pushFront time: " + (end - start) + " ns");

            // pushBack
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.pushBack(i);
            }
            end = System.nanoTime();
            System.out.println("pushBack time: " + (end - start) + " ns");

            // popFront
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.popFront();
            }
            end = System.nanoTime();
            System.out.println("popFront time: " + (end - start) + " ns");

            // popBack
            for (int i = 0; i < size; i++) {
                list.pushBack(i); // Rellenar nuevamente para popBack
            }
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.popBack();
            }
            end = System.nanoTime();
            System.out.println("popBack time: " + (end - start) + " ns");

            // find
            for (int i = 0; i < size; i++) {
                list.pushBack(i); // Rellenar nuevamente para find y erase
            }
            start = System.nanoTime();
            list.find(size / 2); // Buscar el valor medio
            end = System.nanoTime();
            System.out.println("find time: " + (end - start) + " ns");

            // erase
            start = System.nanoTime();
            list.erase(size / 2); // Eliminar el valor medio
            end = System.nanoTime();
            System.out.println("erase time: " + (end - start) + " ns");

            // addBefore
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.addBefore(i, -i); // Insertar antes del elemento i
            }
            end = System.nanoTime();
            System.out.println("addBefore time: " + (end - start) + " ns");

            // addAfter
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.addAfter(i, -i); // Insertar después del elemento i
            }
            end = System.nanoTime();
            System.out.println("addAfter time: " + (end - start) + " ns");

            // size
            start = System.nanoTime();
            int currentSize = list.size(); // Obtener el tamaño de la lista
            end = System.nanoTime();
            System.out.println("size time: " + (end - start) + " ns");

            // topFront
            start = System.nanoTime();
            Integer front = list.topFront(); // Obtener el primer elemento
            end = System.nanoTime();
            System.out.println("topFront time: " + (end - start) + " ns");

            // topBack
            start = System.nanoTime();
            Integer back = list.topBack(); // Obtener el último elemento
            end = System.nanoTime();
            System.out.println("topBack time: " + (end - start) + " ns");

            System.out.println("----------------------------------");
        }
    }
}
