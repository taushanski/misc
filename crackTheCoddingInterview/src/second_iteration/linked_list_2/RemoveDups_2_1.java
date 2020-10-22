package second_iteration.linked_list_2;


import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RemoveDups_2_1 {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.appendToTail(2);
        head.appendToTail(0);
        head.appendToTail(2);
        head.appendToTail(7);
        head.appendToTail(1);
        System.out.println("original Linked List: " + head.printList());
//        removeDupsWithHashMap(head);
        removeDupsWithoutHelperStructure(head);
        System.out.println("Linked List with removed dups: " + head.printList());
    }

    private static void removeDupsWithHashMap(Node<Integer> head) {
        if (isNull(head)) {
            return;
        }
        Map<Integer, Integer> encounteredValues = new HashMap<>();
        encounteredValues.put(head.getData(), head.getData());
        Node<Integer> prev = head;
        while (nonNull(prev) && nonNull(prev.next)) {
            if (encounteredValues.containsKey(prev.next.getData())) { // duplicate value found
                removeNextNode(prev);
            } else {
                encounteredValues.put(prev.next.getData(), prev.next.getData());
            }
            prev = prev.next;
        }
    }

    private static void removeNextNode(Node<Integer> prev) {
        Node<Integer> nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
        nodeToRemove.next = null;
    }

    /*Time O(n^2), space O(1)*/
    private static void removeDupsWithoutHelperStructure(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            /*Run through the other nodes and remove dups*/
            Node<Integer> runner = current;
            while (runner.next != null) {
                if (runner.next.getData() == current.getData()) {//duplicate element
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
