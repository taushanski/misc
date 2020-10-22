import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        System.out.println("Original tree");
        inOrderPrint(root);
        System.out.println();
//        invertBinaryTreeRecursively(root);
        invertBinaryTreeIteratively(root);
        System.out.println("Inverted tree");
        inOrderPrint(root);
    }

    public static void inOrderPrint(BinaryTree root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.println(root.value);
            inOrderPrint(root.right);
        }
    }

    /*Complexity: O(n) time | O(h) space where h is the height of the longest branch */
    public static void invertBinaryTreeRecursively(BinaryTree tree) {
        // Write your code here.
        if (tree != null) {
            BinaryTree left = tree.left;
            tree.left = tree.right;
            tree.right = left;
            invertBinaryTreeRecursively(tree.left);
            invertBinaryTreeRecursively(tree.right);
        }
    }

    /*using a breadth first search traversal O(n) time | O(d)*/
    public static void invertBinaryTreeIteratively(BinaryTree tree) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            BinaryTree currentNode = queue.remove();
            if (currentNode != null) {
                BinaryTree temp = currentNode.left;
                currentNode.left = currentNode.right;
                currentNode.right = temp;
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

    }

    static class BinaryTree {

        public int value;

        public BinaryTree left;

        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
