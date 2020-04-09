package trees_and_graphs;

public class MinHeap {

    private TreeNode root;

    public void insert(int element) {
        TreeNode newNode = new TreeNode(element);
        if (root == null) {
            root = newNode;
        }
        TreeNode bottomRightmostNode = root;
        while (bottomRightmostNode.right != null) {
            bottomRightmostNode = bottomRightmostNode.right;
        }



    }


    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        private TreeNode top;

        public TreeNode(int data) {
            this.data = data;
        }
    }


}

