package second_iteration.linked_list_2;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class DoublyLinkedList<E> {

    private Node<E> head;

    /*O(1)*/
    public void push(E data) {
        Node<E> node = new Node<>(data);
        node.next = head;
        if (nonNull(head)) {
            head.previous = node;
        }
        head = node;
    }

    /* Given a node as prev_node, insert a new node after the given node. O(1) */
    public void insertAfter(Node prevNode, E data) {
        if (isNull(prevNode)) {
            System.out.println("PrevNode cannot be null");
            return;
        }

        Node<E> node = new Node<>(data);
        node.previous = prevNode;
        node.next = prevNode.next;
        prevNode.next = node;
        if (nonNull(node.next)) {
            node.next.previous = node;
        }
    }

    // Add a node at the end of the list. O(N)
    void append(E data) {
        Node<E> node = new Node<>(data);
        if (isNull(head)) {
            head = node;
            return;
        }

        Node<E> last = head;
        while (nonNull(last.next)) {
            last = last.next;
        }

        last.next = node;
        node.previous = last;
    }


    private static class Node<E> {

        private E data;

        private Node<E> previous;

        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
