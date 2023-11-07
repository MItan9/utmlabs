package Queue;

public interface IQueue<T> {
    void enqueue(T element);  // Adds an element to the end of the queue
    T dequeue();              // Removes an element from the front of the queue
    T peek();                 // Returns the front element without removing it
    boolean isEmpty();        // Checks if the queue is empty
    int size();               // Returns the number of elements in the queue
}