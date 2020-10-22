package second_iteration.trees_and_graphs_4;

public class BinaryTreeNode<T> {

    public T data;

    public BinaryTreeNode<T> left;

    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                '}';
    }
}
