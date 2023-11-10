package org.labs.labfour;

import org.labs.labfour.Queue.ArrayQueue;
import org.labs.labfour.Queue.DynamicArrayQueue;
import org.labs.labfour.Queue.LinkedListQueue;
import org.labs.labfour.Stack.ArrayStack;
import org.labs.labfour.Stack.DynamicArrayStack;
import org.labs.labfour.Stack.LinkedListStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing ArrayStack");
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        // Push elements onto the stack
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + arrayStack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + arrayStack.size());

        // Peek at the top element
        System.out.println("Peek at the top element: " + arrayStack.peek());

        // Pop elements from the stack
        while (!arrayStack.isEmpty()) {
            System.out.println("Popped: " + arrayStack.pop());
        }

        // Check if the stack is empty after popping
        System.out.println("Is the stack empty now? " + arrayStack.isEmpty());

        //test ArrayQueue
        System.out.println("\nTesting ArrayQueue");
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();

        // Enqueue elements into the queue
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + arrayQueue.isEmpty());

        // Get the size of the queue
        System.out.println("Queue size: " + arrayQueue.size());

        // Peek at the front element
        System.out.println("Peek at the front element: " + arrayQueue.peek());

        // Dequeue elements from the queue
        while (!arrayQueue.isEmpty()) {
            System.out.println("Dequeued: " + arrayQueue.dequeue());
        }

        // Check if the queue is empty after dequeuing
        System.out.println("Is the queue empty now? " + arrayQueue.isEmpty());

        System.out.println("\nTesting LinkedListStack");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        // Push elements onto the stack
        linkedListStack.push(4);
        linkedListStack.push(5);
        linkedListStack.push(6);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + linkedListStack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + linkedListStack.size());

        // Peek at the top element
        System.out.println("Peek at the top element: " + linkedListStack.peek());

        // Pop elements from the stack
        while (!linkedListStack.isEmpty()) {
            System.out.println("Popped: " + linkedListStack.pop());
        }

        // Check if the stack is empty after popping
        System.out.println("Is the stack empty now? " + linkedListStack.isEmpty());

        System.out.println("\nTesting LinkedListQueue");

        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();

        // Enqueue elements into the queue
        linkedListQueue.enqueue("E");
        linkedListQueue.enqueue("F");
        linkedListQueue.enqueue("G");

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + linkedListQueue.isEmpty());

        // Get the size of the queue
        System.out.println("Queue size: " + linkedListQueue.size());

        // Peek at the front element
        System.out.println("Peek at the front element: " + linkedListQueue.peek());

        // Dequeue elements from the queue
        while (!linkedListQueue.isEmpty()) {
            System.out.println("Dequeued: " + linkedListQueue.dequeue());
        }

        // Check if the queue is empty after dequeuing
        System.out.println("Is the queue empty now? " + linkedListQueue.isEmpty());

        System.out.println("\nTesting DynamicArrayStack");

        DynamicArrayStack<Integer> dynamicArrayStack = new DynamicArrayStack<>();

        // Push elements onto the stack
        dynamicArrayStack.push(7);
        dynamicArrayStack.push(8);
        dynamicArrayStack.push(9);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + dynamicArrayStack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + dynamicArrayStack.size());

        // Peek at the top element
        System.out.println("Peek at the top element: " + dynamicArrayStack.peek());

        // Pop elements from the stack
        while (!dynamicArrayStack.isEmpty()) {
            System.out.println("Popped: " + dynamicArrayStack.pop());
        }

        // Check if the stack is empty after popping
        System.out.println("Is the stack empty now? " + dynamicArrayStack.isEmpty());

        System.out.println("\nTesting DynamicArrayQueue");

        DynamicArrayQueue<String> dynamicArrayQueue = new DynamicArrayQueue<>();

        // Enqueue elements into the queue
        dynamicArrayQueue.enqueue("H");
        dynamicArrayQueue.enqueue("I");
        dynamicArrayQueue.enqueue("J");

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + dynamicArrayQueue.isEmpty());

        // Get the size of the queue
        System.out.println("Queue size: " + dynamicArrayQueue.size());

        // Peek at the front element
        System.out.println("Peek at the front element: " + dynamicArrayQueue.peek());

        // Dequeue elements from the queue
        while (!dynamicArrayQueue.isEmpty()) {
            System.out.println("Dequeued: " + dynamicArrayQueue.dequeue());
        }

        // Check if the queue is empty after dequeuing
        System.out.println("Is the queue empty now? " + dynamicArrayQueue.isEmpty());
    }
}

