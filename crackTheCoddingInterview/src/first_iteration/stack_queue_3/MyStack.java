package first_iteration.stack_queue_3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T data = top.data;

        top = top.next;

        return data;
    }

    public void push(T item) {
        StackNode<T> data = new StackNode<>(item);
        data.next = top;
        top = data;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
