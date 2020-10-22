package second_iteration.trees_and_graphs_4;

public class CheckBST_4_5 {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> binaryTree = new BinaryTreeNode<>(10);
        binaryTree.left = new BinaryTreeNode<>(4);
        binaryTree.left.left = new BinaryTreeNode<>(4);
        binaryTree.left.right = new BinaryTreeNode<>(11);
        binaryTree.right = new BinaryTreeNode<>(15);
        binaryTree.right.left = new BinaryTreeNode<>(11);
        binaryTree.right.right = new BinaryTreeNode<>(16);

        System.out.println("checkBST(binaryTree) = " + checkBST(binaryTree));
    }

    /*in order traversal time O(N) space O(logN)*/
    private static boolean checkBST(BinaryTreeNode<Integer> root) {

        return checkBST(root, null, null);
    }

    private static boolean checkBST(BinaryTreeNode<Integer> root, Integer minValue, Integer maxValue) {
        // base case
        if (root == null) {
            return true;
        } else if ((minValue != null && root.data <= minValue) || (maxValue != null && root.data > maxValue)) {
            return false;
        }
        return checkBST(root.left, minValue, root.data) && checkBST(root.right, root.data, maxValue);
    }

}
