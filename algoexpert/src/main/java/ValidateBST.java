public class ValidateBST {

    public static void main(String[] args) {
        BST root = new BST(5);
        root.left = new BST(4);
        root.right = new BST(7);
        root.left.left = new BST(3);
        root.left.right = new BST(4);
        root.right.left = new BST(6);
        root.right.right = new BST(8);
        System.out.println("validateBst(root) = " + validateBst(root));

    }

    /*Complexity: O(n) | O(d) where d is the depth of the tree  */
    public static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBst(BST tree, int minValue, int maxValue) {
        if (tree == null) {
            return true;
        } else if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        } else {
            return validateBst(tree.left, minValue, tree.value) && validateBst(tree.right, tree.value, maxValue);
        }
    }


    public static void inOrderPrint(BST root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.println(root.value);
            inOrderPrint(root.right);
        }
    }


    static class BST {

        public int value;

        public BST left;

        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
