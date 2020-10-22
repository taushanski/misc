package second_iteration.linked_list_2;

import java.util.Objects;

public class DeleteMiddleNode_2_3 {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        System.out.println("The list before removing the middle node: " + head.printList());
        Node<Integer> middle = head.getNode(3);
        System.out.println("middle = " + middle);

//        removeMiddleNodeByShiftingElenentsToTheEnd(middle);
        removeMiddleNodeByCopyingNextElementAndDeletingIt(middle);
        System.out.println("The list after removing the middlee node: " + head.printList());
    }

    /* the time is O(n/2) where n is the number of nodes */
    private static void removeMiddleNodeByShiftingElenentsToTheEnd(Node<Integer> middle) {
        if (Objects.isNull(middle) || Objects.isNull(middle.next)) { // check that the element is valid element and
            // its not the last one
            return;
        }
        // will go through the rest of the nodes and shift them by one node to the left
        Node<Integer> temp = middle;
        while (Objects.nonNull(temp.next)) {
            temp.setData(temp.next.getData());
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

    /* the time is O(1) */
    private static void removeMiddleNodeByCopyingNextElementAndDeletingIt(Node<Integer> middle) {
        if (Objects.isNull(middle) || Objects.isNull(middle.next)) { // check that the element is valid element and
            // its not the last one
            return;
        }

        Node<Integer> next = middle.next;
        middle.setData(next.getData());
        middle.next = next.next;
        next.next = null;
    }

}
