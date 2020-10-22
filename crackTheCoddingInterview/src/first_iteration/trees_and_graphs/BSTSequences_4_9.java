package first_iteration.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences_4_9 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(2);
        addElement(root, 1);
        addElement(root, 3);
        //        addElement(root, 10);
        //        addElement(root, 6);
        //        addElement(root, 5);
        /*
                2
               / \
              1   3
         */
        printTreePreOrder(root);

        ArrayList<LinkedList<Integer>> constructionArrays = buildBSTConstructionArraySequences(root);
        System.out.println("constructionArrays = " + constructionArrays);


    }

    private static ArrayList<LinkedList<Integer>> buildBSTConstructionArraySequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSequences = buildBSTConstructionArraySequences(node.left);
        ArrayList<LinkedList<Integer>> rightSequences = buildBSTConstructionArraySequences(node.right);

        /* Weave together each list from left and right subtrees */
        for (LinkedList<Integer> left : leftSequences) {
            for (LinkedList<Integer> right : rightSequences) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }

        }

        return result;

    }

    /*
     * Weave lists together in all possible ways. This algorithm works by removing the
     * head from one list, recursing, and then doing the same thing with the other
     * list.
     * */
    private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        // if one of the lists is empty -> add reminder to [a cloned] prefix and store result
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        // Recurse with head of first added to the prefix.
        // Removing the head will damage first, so we'll need to put it back where we found it afterwards
        Integer headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        // Do the same thing with second, damaging and restoring the list
        Integer headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
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

    private static void printTreePreOrder(TreeNode node) {
        List<Integer> elements = new ArrayList<>();
        buildPostOrderElementList(node, elements);
        System.out.println("elements = " + elements);
    }

    private static void buildPostOrderElementList(TreeNode node, List elements) {
        if (node != null) {
            elements.add(node.data);
            buildPostOrderElementList(node.left, elements);
            buildPostOrderElementList(node.right, elements);

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
