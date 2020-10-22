package second_iteration.trees_and_graphs_4;

import static java.lang.Integer.MIN_VALUE;

public class CheckBalanced_4_4 {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> binaryTree = new BinaryTreeNode<>(5);
        binaryTree.left = new BinaryTreeNode<>(4);
        binaryTree.left.left = new BinaryTreeNode<>(10);
        binaryTree.left.right = new BinaryTreeNode<>(12);
        binaryTree.right = new BinaryTreeNode<>(3);
        binaryTree.right.left = new BinaryTreeNode<>(8);
        binaryTree.right.right = new BinaryTreeNode<>(8);
//        binaryTree.right.right.left = new BinaryTreeNode<>(20);
//        binaryTree.right.right.left.left = new BinaryTreeNode<>(30);


        System.out.println("isBalanced(binaryTree) = " + isBalancedNotOptimal(binaryTree));
        System.out.println("isBalanced(binaryTree) = " + isBalancedOptimal(binaryTree));
    }

    /*O(N) time andO(H) space,*/
    private static boolean isBalancedOptimal(BinaryTreeNode<Integer> binaryTree) {
        return checkHeight(binaryTree) != MIN_VALUE;
    }

    private static int checkHeight(BinaryTreeNode<Integer> binaryTree) {
        if (binaryTree == null) {
            return -1; // base case
        }

        int leftHeight = checkHeight(binaryTree.left);
        if (leftHeight == MIN_VALUE) {
            return MIN_VALUE;
        }
        int rightHeight = checkHeight(binaryTree.right);
        if (rightHeight == MIN_VALUE) {
            return MIN_VALUE;
        }
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /*O(NlogN)*/
    private static boolean isBalancedNotOptimal(BinaryTreeNode<Integer> root) {
        if (root == null) { // base case
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalancedNotOptimal(root.left) && isBalancedNotOptimal(root.right);
        }
    }

    private static int getHeight(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


}
