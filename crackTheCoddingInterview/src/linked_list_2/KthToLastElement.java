package linked_list_2;


import linked_list_2.LinkedList.Node;

public class KthToLastElement {

    public static void main(String[] args) {
        LinkedList elements = new LinkedList();
        elements.appendToTail(1);
        elements.appendToTail(2);
        elements.appendToTail(1);
        elements.appendToTail(3);
        int k = 2;
        {
            Node kThElement = kthToLastRecursion(elements.getHead(), k);
            System.out.printf("The %d element is %d%n", k, kThElement.data);
        }
        {
            Node kThElement = kthToLastIteration(elements.getHead(), k);
            System.out.printf("The %d element is %d%n", k, kThElement.data);
        }

    }

    private static Node kthToLastRecursion(Node head, int k) {
        Index index = new Index();
        return kthToLastRecursionImpl(head, k, index);
    }

    private static Node kthToLastRecursionImpl(Node head, int k, Index index) {
        if (head == null) {
            return null;
        }

        Node nextNode = kthToLastRecursionImpl(head.next, k, index);
        index.value++;
        if (index.value == k) {
            return head;
        }
        return nextNode;
    }

    private static Node kthToLastIteration(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        // move p1 k nodes into the list
        for (int i = 0; i <= k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;

        }

        // Move them at the same pace. When p1 hits the end, p2 will be at the right element
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    private static class Index {
        private int value = -1;
    }


}
