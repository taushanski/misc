package first_iteration.trees_and_graphs;

public class ValidateBST_4_5 {
    int index = 0;


    // use the in order traversal to copy the tree into array
    void copyBST(TreeNode root, int[] array) {
        if (root == null) {
            return;
        }

        copyBST(root.left, array);
        array[index] = root.data;
        index++;
        copyBST(root.right, array);
    }

    boolean checkBST(TreeNode root) {
        int[] array = new int[root.size];
        copyBST(root, array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    boolean checkBSTMinMax(TreeNode root) {
        return checkBSTMinMax(root, null, null);
    }

    boolean checkBSTMinMax(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }

        if (!checkBSTMinMax(root.left, min, root.data) || !checkBSTMinMax(root.right, root.data, max)) {
            return false;
        }
        return true;
    }
}
