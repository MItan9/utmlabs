package Stack;
import java.util.ArrayList;
import java.util.List;

public class DynamicArrayStack<T> implements IStack<T> {
    private  List<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
