package second_iteration.stacks_and_queues_3;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private QueueNode<T> first;

    private QueueNode<T> last;

    public void addItem(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) { // the queue is now empty
            last = null;
        }
        return data;
    }

    protected boolean isEmpty() {
        return first == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.data;
    }


    private static class QueueNode<T> {

        private T data;

        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }


}
