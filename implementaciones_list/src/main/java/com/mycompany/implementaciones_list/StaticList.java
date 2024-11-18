
package com.mycompany.implementaciones_list;

import java.util.Arrays;


class StaticList<T> implements ListInterface<T> {
    private T[] data;
    private int capacity;
    private int count;

    @SuppressWarnings("unchecked")
    public StaticList(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.data = (T[]) new Object[capacity];
    }

    private void ensureCapacity() {
        if (count >= capacity) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
    }

    @Override
    public void pushFront(T value) {
        ensureCapacity();
        for (int i = count; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = value;
        count++;
    }

    @Override
    public void pushBack(T value) {
        ensureCapacity();
        data[count++] = value;
    }

    @Override
    public T popFront() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        T front = data[0];
        for (int i = 0; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return front;
    }

    @Override
    public T popBack() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        T back = data[--count];
        return back;
    }

    @Override
    public boolean find(T value) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(value)) return true;
        }
        return false;
    }

    @Override
    public boolean erase(T value) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(value)) {
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    @Override
public void addBefore(T target, T value) {
    // Verificar si la lista está llena
    if (count == data.length) {
        resize(); // Incrementar la capacidad si es necesario
    }

    // Buscar el índice del elemento objetivo
    for (int i = 0; i < count; i++) {
        if (data[i].equals(target)) {
            // Mover elementos hacia la derecha para hacer espacio
            for (int j = count; j > i; j--) {
                data[j] = data[j - 1];
            }
            // Insertar el nuevo valor antes del objetivo
            data[i] = value;
            count++;
            return;
        }
    }

    // Lanzar excepción si no se encuentra el objetivo
    throw new IllegalArgumentException("Target not found");
}

@Override
public void addAfter(T target, T value) {
    // Verificar si la lista está llena
    if (count == data.length) {
        resize(); // Incrementar la capacidad si es necesario
    }

    // Buscar el índice del elemento objetivo
    for (int i = 0; i < count; i++) {
        if (data[i].equals(target)) {
            // Mover elementos hacia la derecha para hacer espacio
            for (int j = count; j > i + 1; j--) {
                data[j] = data[j - 1];
            }
            // Insertar el nuevo valor después del objetivo
            data[i + 1] = value;
            count++;
            return;
        }
    }

    // Lanzar excepción si no se encuentra el objetivo
    throw new IllegalArgumentException("Target not found");
}

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public T topFront() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return data[0];
    }

    @Override
    public T topBack() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return data[count - 1];
    }

    private void resize() {
        int newCapacity = data.length * 2; // Doblar la capacidad
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, count);
        data = newData;
    }
}