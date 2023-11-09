package Stack;

public class ArrayStack<T> implements IStack<T> {
    private T[] array;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (top == array.length - 1) {
            throw new StackOverflowError();
        }
        array[++top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
