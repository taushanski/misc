package second_iteration.linked_list_2;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Partition_2_4 {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);
        System.out.println("The list before partitioning: " + head.printList());

//        System.out.println("The list after partitioning: " + partitionListWithSubLists(head, 5).printList());
        System.out.println("The list after partitioning: " + partitionListViaMovingElements(head, 5).printList());
    }

    /*We will build two sublists one with the elements less then and one with the elements >= of pivot and then we
    will merge them*/

    private static Node<Integer> partitionListWithSubLists(Node<Integer> node, int pivot) {
        if (isNull(node) || isNull(node.next)) {
            return null; // nothing to do
        }

        Node<Integer> lessThenStart = null;
        Node<Integer> lessThenEnd = null;
        Node<Integer> greaterThenOrEqStart = null;
        Node<Integer> greaterThenOrEqEnd = null;

        while (nonNull(node)) {
            Node<Integer> next = node.next;
            node.next = null;
            if (node.getData() < pivot) { // add to the left list
                if (isNull(lessThenStart)) {// the left list is empty
                    lessThenStart = node;
                    lessThenEnd = lessThenStart;
                } else {
                    lessThenEnd.next = node;
                    lessThenEnd = node;
                }
            } else { // add to the right list
                if (isNull(greaterThenOrEqStart)) {// the right list is empty
                    greaterThenOrEqStart = node;
                    greaterThenOrEqEnd = greaterThenOrEqStart;
                } else {
                    greaterThenOrEqEnd.next = node;
                    greaterThenOrEqEnd = node;
                }
            }
            node = next;
        }

        // we have to merge them
        lessThenEnd.next = greaterThenOrEqStart;
        return lessThenStart;

    }

    private static Node<Integer> partitionListViaMovingElements(Node<Integer> node, int pivot) {
        Node<Integer> head = node;
        Node<Integer> tail = node;
        while (nonNull(node)) {
            Node<Integer> next = node.next;
            node.next = null;
            if (node.getData() < pivot) { // insert node at head
                node.next = head;
                head = node;
            } else {// insert node at tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
//        tail.next = null;

        return head;

    }

}

