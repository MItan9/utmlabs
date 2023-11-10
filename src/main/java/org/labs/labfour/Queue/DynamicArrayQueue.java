package org.labs.labfour.Queue;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayQueue<T> implements IQueue<T> {
    private List<T> list = new ArrayList<>();
    private int front = 0; // Отслеживаем "начало" очереди

    @Override
    public void enqueue(T item) {
        list.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(front); // Удаляем элемент из начала списка, O(n) операция
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(front);
    }

    @Override
    public boolean isEmpty() {
        return front >= list.size(); // Очередь пуста, если "начало" за пределами списка
    }

    @Override
    public int size() {
        return list.size() - front; // Размер - это разница между общим количеством элементов и "началом" очереди
    }
}
