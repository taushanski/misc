package first_iteration.linked_list_2;

import first_iteration.linked_list_2.LinkedList.Node;

public class ListIntersection {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        Node commonNode = new Node(3);
        list1.appendToTail(1).appendToTail(2).appendToTail(commonNode).appendToTail(4);
        LinkedList list2 = new LinkedList();
        list2.appendToTail(5).appendToTail(commonNode);

        Node intersection = findIntersection(list1, list2);

        System.out.printf("The intersection point is: %s", intersection);


    }

    private static Node findIntersection(LinkedList list1, LinkedList list2) {
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.getTail() != result2.getTail()) {
            return null;
        }

        LinkedList shorterList = result1.getSize() < result2.getSize() ? list1 : list2;
        LinkedList longerList = result1.getSize() < result2.getSize() ? list2 : list1;

        Node longerListHead = longerList.getNode(Math.abs(result1.getSize() - result2.getSize()));

        Node shorterListHead = shorterList.getHead();
        while (shorterListHead != longerListHead) {
            shorterListHead = shorterListHead.next;
            longerListHead = longerListHead.next;

        }

        return longerListHead;

    }

    private static Result getTailAndSize(LinkedList list2) {
        Node tail = list2.getHead();
        if (tail == null) {
            return null;
        }
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        return new Result(size, tail);
    }

    static class Result {
        int size;
        Node tail;

        public Result(int size, Node tail) {
            this.size = size;
            this.tail = tail;
        }

        public int getSize() {
            return size;
        }

        public Node getTail() {
            return tail;
        }
    }
}
