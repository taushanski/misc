package second_iteration.linked_list_2;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class SumLists_2_5 {

    public static void main(String[] args) {
        Node<Integer> num1 = new Node<>(7);
        num1.appendToTail(1);
        num1.appendToTail(6);
        Node<Integer> num2 = new Node<>(5);
        num2.appendToTail(9);
        num2.appendToTail(2);
        System.out.println("num1.printList() = " + num1.printList());
        System.out.println("num2.printList() = " + num2.printList());
        System.out.println("sumLists(num1, num2) = " + sumLists(num1, num2).printList());
        System.out.println("sumListsRecurse(num1, num2) = " + sumListsRecurse(num1, num2).printList());

    }

    private static Node<Integer> sumLists(Node<Integer> num1, Node<Integer> num2) {
        Node<Integer> sumHead = null;
        int reminder = 0;
        while (num1 != null && num2 != null) {
            int nextDigitsSum = num1.getData() + num2.getData() + reminder;
            int s = nextDigitsSum % 10;
            reminder = nextDigitsSum / 10;
            if (sumHead == null) {
                sumHead = new Node<>(s);
            } else {
                sumHead.appendToTail(s);
            }
            num1 = num1.next;
            num2 = num2.next;
        }

        return sumHead;
    }

    private static Node<Integer> sumListsRecurse(Node<Integer> list1, Node<Integer> list2) {
        return sumListsRecurseImpl(list1, list2, 0);
    }

    private static Node<Integer> sumListsRecurseImpl(Node<Integer> list1, Node<Integer> list2, int carry) {
        if (isNull(list1) && isNull(list2)) {
            return null;
        }

        int sum = carry;
        if (nonNull(list1)) {
            sum += list1.getData();
        }
        if (nonNull(list2)) {
            sum += list2.getData();
        }
        Node<Integer> resultList = new Node<>(sum % 10);
        carry = sum / 10;
        if (nonNull(list1) || nonNull(list2)) {
            resultList.next = sumListsRecurseImpl(list1 == null ? null : list1.next,
                                                  list2 == null ? null : list2.next, carry);
        }
        return resultList;
    }
}
