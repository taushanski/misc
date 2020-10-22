package first_iteration.trees_and_graphs;

public class CreateMinimumBST_4_2 {

    TreeNode createMinimumBST(int[] array) {
        return createMinimumBST(array, 0, array.length - 1);
    }

    private TreeNode createMinimumBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode n = new TreeNode(array[middle]);
        n.left = createMinimumBST(array, 0, middle - 1);
        n.right = createMinimumBST(array, middle + 1, array.length);
        return n;
    }
}
