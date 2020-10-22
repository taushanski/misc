package first_iteration.linked_list_2;

import first_iteration.linked_list_2.LinkedList.Node;

public class IsPalindrome {
    public static void main(String[] args) {
        LinkedList palindrome = new LinkedList();
        palindrome.appendToTail(1).appendToTail(2).appendToTail(3).appendToTail(4).appendToTail(35).appendToTail(2)
                  .appendToTail(1);
        System.out.printf("The following list : %s is palindrome: %b", palindrome, isPalindrome(palindrome));

    }

    private static boolean isPalindrome(LinkedList elements) {
        LinkedList reversed = reverseAndClone(elements);
        return isEqual(elements, reversed);
    }

    private static LinkedList reverseAndClone(LinkedList elements) {
        Node next = elements.getHead();
        LinkedList reversed = new LinkedList();
        while (next != null) {
            Node clone = new Node(next.data);
            reversed.prependToHead(clone);
            next = next.next;
        }
        return reversed;
    }

    private static boolean isEqual(LinkedList elements, LinkedList reversed) {
        Node head1 = elements.getHead();
        Node head2 = reversed.getHead();
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }
}
