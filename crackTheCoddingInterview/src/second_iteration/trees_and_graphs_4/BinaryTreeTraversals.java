package second_iteration.trees_and_graphs_4;

public class BinaryTreeTraversals {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

        root.left = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(4);
        root.right = new BinaryTreeNode<>(9);
        root.right.left = new BinaryTreeNode<>(7);
        root.right.right= new BinaryTreeNode<>(10);

        System.out.println("inOrderTraversal:");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("preOrderTraversal:");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("postOrderTraversal:");
        postOrderTraversal(root);
    }

    public static <T> void inOrderTraversal(BinaryTreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + ", ");
            inOrderTraversal(node.right);
        }
    }

    public static <T> void preOrderTraversal(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    public static <T> void postOrderTraversal(BinaryTreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            System.out.print(node.data + ", ");
        }
    }

}
