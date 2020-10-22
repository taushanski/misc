package first_iteration.linked_list_2;


public class PartitionLIst {
    public static void main(String[] args) {
        LinkedList elements = new LinkedList();
        elements.appendToTail(3);
        elements.appendToTail(5);
        elements.appendToTail(8);
        elements.appendToTail(5);
        elements.appendToTail(10);
        elements.appendToTail(2);
        elements.appendToTail(1);

        System.out.printf("The list before partition: %s%n", elements);
        elements.partition2(5);

        System.out.printf("The list after partition: %s%n", elements);
    }
}
