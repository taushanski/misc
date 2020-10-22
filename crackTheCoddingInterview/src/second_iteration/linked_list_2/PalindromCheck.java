package second_iteration.linked_list_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromCheck {

    public static void main(String[] args) {
        Node<Integer> palindrome = new Node<>(1);
        palindrome.appendToTail(2);
        palindrome.appendToTail(3);
        palindrome.appendToTail(2);
        palindrome.appendToTail(1);
        palindrome.appendToTail(3);
        System.out.println("palindrome.printList() = " + palindrome.printList());
        System.out.println(
                "isPalindromeCheckVieReversingList(palindrome) = " + isPalindromeCheckVieReversingList(palindrome));
        System.out.println("isPalindromeCheckViaStack(palindrome) = " + isPalindromeCheckViaStack(palindrome));

    }

    // time complexity O(n)
    private static boolean isPalindromeCheckVieReversingList(Node<Integer> head) {
        Node<Integer> reversed = reverseAndCloneList(head);
        return isEqual(head, reversed);
    }

    private static Node<Integer> reverseAndCloneList(Node<Integer> node) {
        Node<Integer> reversedHead = null;
        while (node != null) {
            Node<Integer> clone = new Node<>(node.getData());
            clone.next = reversedHead;
            reversedHead = clone;
            node = node.next;
        }
        return reversedHead;
    }

    private static boolean isEqual(Node<Integer> one, Node<Integer> two) {
        while (one != null && two != null) {
            if (one.getData() != two.getData()) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    private static boolean isPalindromeCheckViaStack(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Deque<Integer> stack = new ArrayDeque<>();
        /* Push elements from first half of linked list onto stack. When fast runner
         * (which is moving at 2x speed) reaches the end of the linked list, then we
         * know we're at the middle
         */
        while (fast != null && fast.next != null) {
            stack.addFirst(slow.getData());
            slow = slow.next;
            fast = fast.next.next;
        }
        /*Has odd number of elements, so skip the middle element*/
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            Integer top = stack.removeFirst();
            if (top != slow.getData()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

}
