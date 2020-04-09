package linked_list_2;

import static linked_list_2.LinkedList.*;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList elements = new LinkedList();
        elements.appendToTail(0);
        elements.appendToTail(1);
        elements.appendToTail(2);
        elements.appendToTail(3);
        elements.appendToTail(4);
        Node middle = elements.getNode(4);
        System.out.printf("Middle element value is: %d%n", middle.data);
        System.out.printf("The list before delete: %s%n", elements);
        System.out.printf("Element deleted: %b%n", elements.deleteMiddleNode(middle));
        System.out.printf("The list after delete: %s%n", elements);
    }
}
