package second_iteration.linked_list_2;

import java.util.Objects;

public class KthToLast_2_2 {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        System.out.println("findKthToLastElement(head, 3) = " + findKthToLastElement(head, 1));
    }
/*Time O(n)*/
    private static Integer findKthToLastElement(Node<Integer> head, int kThToLast) {
        if (head == null) {
            throw new IllegalArgumentException("head is null");
        }

        Node<Integer> current = head;
        Node<Integer> runner = head; // this one is k elements ahead of current
        for (int i = 0; i < kThToLast && Objects.nonNull(runner); i++) {
            runner = runner.next;
        }

        if (runner == null) {
            return null;
        }

        while (Objects.nonNull(current) && Objects.nonNull(runner)) {
            runner = runner.next;
            current = current.next;
        }

        if (Objects.isNull(runner) && Objects.nonNull(current)) {
            return current.getData();
        } else {
            return null;
        }
    }

}
