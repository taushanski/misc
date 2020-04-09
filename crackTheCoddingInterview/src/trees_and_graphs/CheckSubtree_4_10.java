package trees_and_graphs;

public class CheckSubtree_4_10 {

    public static void main(String[] args) {


    }


    static boolean containsTree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) { // empty tree is always a subtree
            return true;
        }
        return subTree(t1, t2);
    }

    private static boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false; // big tree must not be empty
        } else if (t1.data == t2.data && machTree(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2.left);
    }

    private static boolean machTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) { // only one is null
            return false;
        } else if (t1.data != t2.data) {
            return false;
        }
        return machTree(t1.left, t2.left) && machTree(t1.right, t2.right);
    }

    // O(n+m) time and space
    static boolean containsTree1(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        getPreOrderString(t1, sb1);
        getPreOrderString(t2, sb2);

        return sb1.indexOf(sb2.toString()) != -1;
    }

    private static void getPreOrderString(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("X");
            return;
        }

        result.append(node.data);
        getPreOrderString(node.left, result);
        getPreOrderString(node.right, result);
    }

    static void addElement(TreeNode root, int element) {
        if (root == null) {
            return;
        }
        TreeNode node = new TreeNode(element);
        TreeNode temp = root;
        while (temp != null) {
            if (element <= temp.data) { // left branch
                if (temp.left == null) {
                    temp.left = node;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    static class TreeNode {

        public int data;
        public TreeNode left;

        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TreeNode{");
            sb.append("data=").append(data);
            sb.append('}');
            return sb.toString();
        }
    }
}
