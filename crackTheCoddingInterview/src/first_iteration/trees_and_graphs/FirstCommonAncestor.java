package first_iteration.trees_and_graphs;


public class FirstCommonAncestor {


    public TreeNodeWithParentLink commonAncestorWithParentLink(TreeNodeWithParentLink p, TreeNodeWithParentLink q) {
        int depthDelta = depth(p) - depth(q);
        TreeNodeWithParentLink first = depthDelta > 0 ? q : p; // shallower node
        TreeNodeWithParentLink second = depthDelta > 0 ? p : q; // deeper node
        second = goUpBy(second, Math.abs(depthDelta));
        //Find where path intersects
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : second;
    }

    private TreeNodeWithParentLink goUpBy(TreeNodeWithParentLink second, int steps) {
        TreeNodeWithParentLink result = second;
        while (second != null && steps > 0) {
            result = result.parent;
            steps--;
        }
        return result;
    }

    private int depth(TreeNodeWithParentLink node) {
        int depth = 0;
        TreeNodeWithParentLink temp = node;
        while (temp != null) {
            temp = temp.parent;
            depth++;
        }
        return depth;
    }


    static class TreeNodeWithParentLink {

        public int data;
        public TreeNodeWithParentLink left;

        public TreeNodeWithParentLink right;
        public TreeNodeWithParentLink parent;
        public int size;

        public TreeNodeWithParentLink(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }


    }

}
