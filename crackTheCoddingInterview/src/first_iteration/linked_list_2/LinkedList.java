package first_iteration.linked_list_2;

public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public LinkedList appendToTail(int data) {
        Node tail = new Node(data);
        if (head == null) {
            head = tail;
            return this;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = tail;
        return this;
    }

    public LinkedList appendToTail(Node tail) {
        if (head == null) {
            head = tail;
            return this;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = tail;
        return this;
    }

    public void prependToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }


    public void deleteNode(int data) {
        Node prev = null;
        if (head != null && head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            prev.next = temp.next;
        }
    }

    public Node getNode(int index) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                sb.append(",");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }

    // given an element somewhere in the middle delete it
    public boolean deleteMiddleNode(Node middle) {
        if (middle == null || middle.next == null) { // if last or null return
            return false;
        }
        middle.data = middle.next.data;
        middle.next = middle.next.next;
        return true;
    }

    public void partition(int x) {
        Node tail = head;

        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            if (temp.data < x) {
                // insert node at head
                temp.next = head;
                head = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            temp = next;
        }
        tail.next = null;
    }

    public void partition2(int x) {
        Node lessThanHead = null;
        Node lessThanTail = null;
        Node biggerThanHead = null;
        Node biggerThanTail = null;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = null;
            if (temp.data < x) {
                if (lessThanHead == null) {
                    lessThanHead = temp;
                    lessThanTail = lessThanHead;
                } else {
                    lessThanTail.next = temp;
                    lessThanTail = temp;
                }
            } else {
                if (biggerThanHead == null) {
                    biggerThanHead = temp;
                    biggerThanTail = biggerThanHead;
                } else {
                    biggerThanTail.next = temp;
                    biggerThanTail = temp;
                }
            }
            temp = next;
        }

        if (lessThanHead != null) {
            lessThanTail.next = biggerThanHead;
            head = lessThanHead;
        } else {
            head = biggerThanHead;
        }

        head = lessThanHead;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }

}
