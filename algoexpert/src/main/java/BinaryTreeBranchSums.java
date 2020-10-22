import java.util.ArrayList;
import java.util.List;

public class BinaryTreeBranchSums {

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

        System.out.println("branchSums(root) = " + branchSums(root));
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<Integer>();
        branchSums(root, sums, 0);
        return sums;
    }

    private static void branchSums(BinaryTree node, List<Integer> sums, int partialBranchSum) {
        if (node != null) {
            int branchSum = partialBranchSum + node.value;
            branchSums(node.left, sums, branchSum);
            if (node.left == null && node.right==null) { // we are on a leaf node
                sums.add(branchSum);
            }
            branchSums(node.right, sums, branchSum);
        }
    }

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {

        int value;

        BinaryTree left;

        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
