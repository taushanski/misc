package second_iteration.trees_and_graphs_4;

public class GetRandomNode_4_11 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        System.out.println("node = " + node.size);
        node.insertInOrder(3);
        System.out.println("node = " + node.size);
        node.insertInOrder(10);
        System.out.println("node = " + node.size);
        node.insertInOrder(4);
        System.out.println("node = " + node.size);
    }

    public static class TreeNode {

        int data;

        TreeNode left;

        TreeNode right;

        int size;

        public TreeNode(int data) {
            this.data = data;
            this.size = 1;
        }

        public void insertInOrder(int element) {
            if (element <= data) { // put it on the left
                if (left == null) {
                    left = new TreeNode(element);
                } else {
                    left.insertInOrder(element);
                }
            } else { // put it on the right
                if (right == null) {
                    right = new TreeNode(element);
                } else {
                    right.insertInOrder(element);
                }
            }
            size++;
        }
    }
}
