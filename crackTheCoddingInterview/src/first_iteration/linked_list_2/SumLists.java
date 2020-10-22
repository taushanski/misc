package first_iteration.linked_list_2;

public class SumLists {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.appendToTail(7).appendToTail(1);
        LinkedList l2 = new LinkedList();
        l2.appendToTail(5).appendToTail(9).appendToTail(2);
        System.out.printf("Digit 1: %s%n", l1);
        System.out.printf("Digit 2: %s%n", l2);
        System.out.printf("Result: %s%n", sumLists(l1, l2));
    }

    private static LinkedList sumLists(LinkedList l1, LinkedList l2) {
        LinkedList sum = new LinkedList();
        LinkedList.Node digit1 = l1.getHead();
        LinkedList.Node digit2 = l2.getHead();
        int reminder = 0;
        while (digit1 != null || digit2 != null) {
            int nextDigitSum = 0;
            if (digit1 != null && digit2 != null) {
                nextDigitSum = digit1.data + digit2.data + reminder;
                reminder = nextDigitSum / 10;
                nextDigitSum = nextDigitSum% 10;
                digit1 = digit1.next;
                digit2 = digit2.next;
            } else if (digit1 != null) {
                nextDigitSum = digit1.data + reminder;
                reminder = nextDigitSum / 10;
                nextDigitSum = nextDigitSum% 10;
                digit1 = digit1.next;
            } else {
                nextDigitSum = digit2.data + reminder;
                reminder = nextDigitSum / 10;
                nextDigitSum = nextDigitSum% 10;
                digit2 = digit2.next;
            }

            sum.appendToTail(nextDigitSum);
        }
        return sum;
    }
}
