package trees_and_graphs;


import java.util.ArrayList;
import java.util.LinkedList;

public class CreateLevelLinkedLists_4_3 {

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedListsPreOrderTraversal(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedListsPreOrderTraversal(root, lists, 0);
        return lists;
    }

    private void createLevelLinkedListsPreOrderTraversal(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,
            int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> currentLevelList = null;
        if (lists.size() == level) {
            currentLevelList = new LinkedList<>();
            /*
            Levels are always traversed in order. So, if this is the first time we've
            visited level i, we must have seen levels 0 through i - 1. We can
            therefore safely add the level at the end.
             */
            lists.add(currentLevelList);
        } else {
            currentLevelList = lists.get(level);
        }
        currentLevelList.add(root);
        createLevelLinkedListsPreOrderTraversal(root.left, lists, level + 1);
        createLevelLinkedListsPreOrderTraversal(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedListsBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> resultLists = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            resultLists.add(current); // add previous level
            // Go to next level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                // visit the children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return resultLists;
    }
}
