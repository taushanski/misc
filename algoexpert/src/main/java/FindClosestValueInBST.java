public class FindClosestValueInBST {

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.right = new BST(22);
        root.right.left.right = new BST(14);

        int targetNumber = 16;
        System.out.println("findClosestValueInBst(root, targetNumber) = " + findClosestValueInBst(root, targetNumber));

    }

    private static int findClosestValueInBst(BST root, int targetNumber) {
        return findClosestValueInBst(root, targetNumber, Integer.MIN_VALUE);
    }

    private static int findClosestValueInBst(BST node, int targetNumber, int closestValue) {
        if (node == null) {
            return closestValue;
        }
        if (Math.abs(node.value - targetNumber) < Math.abs(closestValue - targetNumber)) {
            closestValue = node.value;
        }
        if (node.value > targetNumber && node.left != null) { // check on the left
            return findClosestValueInBst(node.left, targetNumber, closestValue);
        } else if (node.value < targetNumber && node.right != null) { // check on the right
            return findClosestValueInBst(node.right, targetNumber, closestValue);
        } else {
            return closestValue;
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
