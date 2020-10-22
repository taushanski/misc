public class BinaryTreeNodeDepthsSum {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right.left = new BinaryTree(10);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println("nodeDepths(root) = " + nodeDepths(root));
    }

    /*Its a depth first search algorithm, pre-order traversal. Complexity: O(n) time | O(h) space where h is the
    height*/
    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);
    }

    private static int nodeDepths(BinaryTree node, int currentDepth) {
        if (node == null) { // base case
            return 0;
        } else if (node.left == null && node.right == null) { // current node is a leaf
            return currentDepth;
        } else {
            return currentDepth + nodeDepths(node.left, currentDepth + 1) + nodeDepths(node.right, currentDepth + 1);
        }

    }

    static class BinaryTree {

        int value;

        BinaryTree left;

        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
