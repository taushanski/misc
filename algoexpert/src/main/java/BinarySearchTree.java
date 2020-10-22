public class BinarySearchTree {

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.right = new BST(22);
        root.right.left.right = new BST(14);

        root.insert(12);
        System.out.println(root);

    }

    static class BST {

        public int value;

        public BST left;

        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) { // it should be on the left
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
                // Do not edit the return statement of this method.
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if (this.value == value) {
                return true;
            } else if (value < this.value && this.left != null) { // its on the left
                return this.left.contains(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.contains(value);
            } else {
                return false;
            }
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            remove(value, null);
            return this;
        }

        private void remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else { // the current node is the one to be removed
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) { // we are dealing with the root node
                    if (left != null) {
                        this.value = left.value;
                        this.right = left.right;
                        this.left = left.left;

                    } else if (right != null) {
                        this.value = right.value;
                        this.left = right.left;
                        this.right = right.right;
                    } else {
                        //this is a single node three
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }

            }
        }

        private int getMinValue() {
            if (left == null) {
                return value;
            } else {
                return left.getMinValue();
            }
        }
    }

}
