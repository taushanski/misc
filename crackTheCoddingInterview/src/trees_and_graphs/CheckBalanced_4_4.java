package trees_and_graphs;


public class CheckBalanced_4_4 {

    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else { // recurse
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftBranchHeight = checkHeight(root.left);
        if (leftBranchHeight == Integer.MIN_VALUE) {
            return leftBranchHeight;
        }

        int rightBranchHeight = checkHeight(root.left);
        if (rightBranchHeight == Integer.MIN_VALUE) {
            return rightBranchHeight;
        }

        int heightDiff = leftBranchHeight - rightBranchHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftBranchHeight, rightBranchHeight) + 1;
        }

    }

    boolean isBalancedOptimal(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
