package linked_list_2;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        {
            LinkedList elements = new LinkedList();
            elements.appendToTail(1);
            elements.appendToTail(2);
            elements.appendToTail(1);
            elements.appendToTail(3);
            System.out.printf("Before removing duplicates with Buffer %s%n", elements.toString());
            deleteDuplicatesWithBuffer(elements);
            System.out.printf("After removing duplicates with bugger %s%n", elements.toString());
        }
        {
            LinkedList elements = new LinkedList();
            elements.appendToTail(1);
            elements.appendToTail(2);
            elements.appendToTail(1);
            elements.appendToTail(3);
            System.out.printf("Before removing duplicates without Buffer %s%n", elements.toString());
            deleteDuplicatesWithoutBuffer(elements);
            System.out.printf("After removing duplicates without buffer %s%n", elements.toString());
        }
    }

    private static void deleteDuplicatesWithBuffer(LinkedList elements) { // takes O(N) time
        LinkedList.Node currentElement = elements.getHead();
        LinkedList.Node prev = null;
        HashSet<Integer> uniqueElements = new HashSet<>();
        while (currentElement != null) {
            if (uniqueElements.contains(currentElement.data)) {
                prev.next = currentElement.next;
            } else {
                uniqueElements.add(currentElement.data);
                prev = currentElement;
            }
            currentElement = currentElement.next;
        }
    }

    private static void deleteDuplicatesWithoutBuffer(LinkedList elements) { // takes O(N^2) time but O(1) space
        LinkedList.Node currentElement = elements.getHead();
        LinkedList.Node runner = null;
        while (currentElement != null) {
            runner = currentElement;
            while (runner.next != null) {
                if (runner.next.data == currentElement.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            currentElement = currentElement.next;
        }
    }
}
