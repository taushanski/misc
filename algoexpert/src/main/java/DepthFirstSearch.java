import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {
        /*
         *            A
         *           / | \
         *          B  C  D
         *        /  \   /  \
         *       E    F  G   H
         *           / \   \
         *          I    J  K
         * */
        Node a = new Node("A");
        Node b = a.addChild("B");
        b.addChild("E");
        Node f = b.addChild("F");
        f.addChild("I");
        f.addChild("J");
        a.addChild("C");
        Node d = a.addChild("D");
        d.addChild("G").addChild("K");
        d.addChild("H");
        System.out.println(
                "a.depthFirstSearch(new ArrayList<String>()) = " + a.depthFirstSearch(new ArrayList<String>()));

    }

    static class Node {

        String name;

        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        /*`Complexity: O(v+e) time |  O(v) space where v is the vertices and e are the edges*/
        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            for (Node nextChild : children) {
                nextChild.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
