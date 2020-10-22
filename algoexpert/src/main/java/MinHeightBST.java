import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST bst = minHeightBst(array);
        System.out.println(bst);
    }
    /*Complexity: O(n) time | O(h) where h is the height of the tree*/
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBstHelper(array, 0, array.size() - 1);
    }

    private static BST minHeightBstHelper(List<Integer> array, int startIndex, int endIndex) {
        if (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            BST node = new BST(array.get(middleIndex));
            node.left = minHeightBstHelper(array, startIndex, middleIndex - 1);
            node.right = minHeightBstHelper(array, middleIndex + 1, endIndex);
            return node;
        }
        return null;
    }

    static class BST {

        public int value;

        public BST left;

        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
