package second_iteration.trees_and_graphs_4;

public class MinimalTree_4_2 {

    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        BinaryTreeNode<Integer> binarySearchTree = buildBinarySearchTree(elements);

        BinaryTreeTraversals.inOrderTraversal(binarySearchTree);
    }

    private static BinaryTreeNode<Integer> buildBinarySearchTree(int[] elements) {
        return buildMinimumBinarySearchTree(elements, 0, elements.length - 1);
    }

    private static BinaryTreeNode<Integer> buildMinimumBinarySearchTree(int[] elements, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int midElementIndex = (startIndex + endIndex) / 2;

        BinaryTreeNode<Integer> midNode = new BinaryTreeNode<>(elements[midElementIndex]);

        midNode.left = buildMinimumBinarySearchTree(elements, startIndex, midElementIndex - 1);

        midNode.right = buildMinimumBinarySearchTree(elements, midElementIndex + 1, endIndex);

        return midNode;
    }

}
