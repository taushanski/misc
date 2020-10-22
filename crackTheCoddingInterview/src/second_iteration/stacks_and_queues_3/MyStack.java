package second_iteration.stacks_and_queues_3;

import java.util.EmptyStackException;

import static java.util.Objects.isNull;

// LIFO ordering. push and pop/peek offer 0(1) time
public class MyStack<T> {

    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = top.data;
        top = top.next;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return isNull(top);
    }


    private static class StackNode<T> {

        private T data;

        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }
}
