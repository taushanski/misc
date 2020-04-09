public class LinkedListExample {

    private static final class MyNode<E> {
        private E data;
        private MyNode<E> next;
        private MyNode<E> previous;

        private MyNode(E data) {
            this.data = data;
        }
    }

    public static final class MyDoublyLinkedList<E> {
        private MyNode<E> head;
        private MyNode<E> tail;

        // time complexity O(1)
        public void add(E data) {
            MyNode<E> newNode = new MyNode<>(data);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                newNode.previous = tail;
                tail.next = newNode;
                tail = newNode;
            }
        }

        // time complexity O(N)
        public void remove(E element) {
            if (isEmpty()) {
                return;
            } else if (head.data.equals(element)) {
                head = head.next;
                head.previous = null;
            } else if (tail.data.equals(element)) {
                tail = tail.previous;
                tail.next = null;
            } else {
                MyNode<E> previous = head;
                while (previous.next != null && !previous.next.data.equals(element)) {
                    previous = previous.next;
                }
                if (previous != null) {
                    MyNode<E> next = previous.next;
                    previous.next = next.next;
                    next.next.previous = previous;
                    next.next = null;
                    next.previous = null;

                }
            }
        }

        protected boolean isEmpty() {
            return head == null;
        }
    }

}
