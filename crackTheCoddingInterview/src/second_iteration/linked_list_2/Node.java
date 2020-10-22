package second_iteration.linked_list_2;

import java.util.Objects;

public class Node<E> {

    private E data;

    public Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void appendToTail(E data) {
        Node<E> node = new Node<>(data);
        Node<E> temp = this;
        while (Objects.nonNull(temp.next)) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * @param index
     * @return the element at the given index
     */
    public Node<E> getNode(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<E> temp = this;
        for (int i = 0; i < index && Objects.nonNull(temp); i++) {
            temp = temp.next;
        }
        return temp;
    }

    public String printList() {
        StringBuilder sb = new StringBuilder("{");
        Node<E> temp = this;
        while (Objects.nonNull(temp)) {
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public void setData(E data) {
        this.data = data;
    }
}
