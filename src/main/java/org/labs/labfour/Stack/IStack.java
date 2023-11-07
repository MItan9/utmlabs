package Stack;

public interface IStack<T> {
    void push(T element);  // Pushes an element onto the stack
    T pop();               // Removes the top element from the stack
    T peek();              // Returns the top element without removing it from the stack
    boolean isEmpty();     // Checks if the stack is empty
    int size();            // Returns the number of elements in the stack
}
