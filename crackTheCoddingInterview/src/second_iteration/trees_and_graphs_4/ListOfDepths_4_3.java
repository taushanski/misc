package second_iteration.trees_and_graphs_4;

import com.sun.source.tree.Tree;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths_4_3 {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> binaryTree = new BinaryTreeNode<>(5);
        binaryTree.left = new BinaryTreeNode<>(4);
        binaryTree.left.left = new BinaryTreeNode<>(10);
        binaryTree.left.right = new BinaryTreeNode<>(12);
        binaryTree.right = new BinaryTreeNode<>(3);
        binaryTree.right.left = new BinaryTreeNode<>(8);
        binaryTree.right.right = new BinaryTreeNode<>(8);

        List<LinkedList<Integer>> depthsElements = fillElementsAtEachDepth(binaryTree);
        System.out.println("depthsElements = " + depthsElements);

    }

    // time complexity is O(N) space O(N)
    private static List<LinkedList<Integer>> fillElementsAtEachDepth(BinaryTreeNode<Integer> binaryTree) {
        List<LinkedList<Integer>> depthElements = new ArrayList<>();
        fillElementsAtEachDepth(binaryTree, depthElements, 0);
        return depthElements;
    }

    // pre order traversal implementation: O(N) time and O(N data + lonN recursive calls) which is O(N)
    private static void fillElementsAtEachDepth(BinaryTreeNode<Integer> node, List<LinkedList<Integer>> depthElements, int currentDepth) {
        if (node != null) {
            if (currentDepth == depthElements.size()) {
                depthElements.add(new LinkedList<>());
            }
            LinkedList<Integer> elements = depthElements.get(currentDepth);
            elements.add(node.data);
            fillElementsAtEachDepth(node.left, depthElements, currentDepth + 1);
            fillElementsAtEachDepth(node.right, depthElements, currentDepth + 1);
        }
    }

    // this is modified breath - first search algorithm : time complexity O(N) and O(N) space but this doesn't
    // require the O(logN ) recursive calls from previous solution so its actually using less space.
    private static List<LinkedList<BinaryTreeNode<Integer>>> createLevelLinkedLists(BinaryTreeNode<Integer> root) {
        List<LinkedList<BinaryTreeNode<Integer>>> result = new ArrayList<>();

        // current level
        LinkedList<BinaryTreeNode<Integer>> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            // add previous level
            result.add(current);
            LinkedList<BinaryTreeNode<Integer>> parents = current; // go to the next level
            current = new LinkedList<>();
            for (BinaryTreeNode<Integer> parent : parents) {
                // visit the children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }

            }

        }
        return result;

    }

}
