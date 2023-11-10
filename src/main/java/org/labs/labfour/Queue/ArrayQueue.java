package org.labs.labfour.Queue;

public class ArrayQueue<T> implements IQueue<T> {
    private Object[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public void enqueue(T item) {
        if (size == array.length) {
            resize();
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) array[front];
        array[front] = null; // prevent memory leak
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = size;
    }
}
