package second_iteration.linked_list_2;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class SinglyLinkedList<E> {

    private Node<E> head;

    /* This function is in LinkedList class. Inserts a
    new Node at front of the list. Time complexity is O(1)
     */
    public void push(E data) {
        Node<E> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    /**
     * This function is in LinkedList class.
     * Inserts a new node after the given prev_node.
     * Time complexity of insertAfter() is O(1) as it does constant amount of work
     */
    public void insertAfter(Node<E> prev, E data) {
        if (isNull(prev)) {
            System.out.println("Its not allowed to insert after null element");
            return;
        }

        Node<E> node = new Node<>(data);
        node.next = prev.next;
        prev.next = node;
    }

    /* Appends a new node at the end.  This method is
     *defined inside LinkedList class shown above.
     * Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head to end, the function does O(n) work.
This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list/
     */
    public void append(E data) {
        Node<E> node = new Node<>(data);
        if (isNull(head)) {
            head = node;
            return;
        }
        // find tail
        Node<E> tail = head;
        while (nonNull(tail.next)) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /* Given a key, deletes the first occurrence of key in linked list .
     * Time complexity is 0(n)
     */
    public void deleteNode(E key) {
        if (isNull(head)) {
            return;
        }

        // this covers also the case with the head holding the data
        Node<E> prev = head;
        Node<E> temp = head;
        while (nonNull(temp) && !key.equals(temp.data)) {
            prev = temp;
            temp = temp.next;
        }

        if (Objects.nonNull(temp)) { // unlink the temp node
            prev.next = temp.next;
        }
    }


    /* Given a reference (pointer to pointer) to the head of a list
           and a position, deletes the node at the given position. O(k) where k is the position */
    public void deleteNode(int position) {
        if (head == null) {
            // empty
            return;
        }

        Node<E> temp = head;

        if (position == 0) { // head needs to be removed
            head = temp.next;
        }

        for (int i = 0; i < position - 1 && nonNull(temp); i++) {
            temp = temp.next;
        }
        // the possition is out of bounds
        if (isNull(temp) || isNull(temp.next)) {
            return;
        }
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        temp.next = temp.next.next;
    }


    public static class Node<E> {

        private E data;

        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }


}
