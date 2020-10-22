package first_iteration.system_design;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    public static int MAX_SIZE = 10;
    public Node head;
    public Node tail;
    public Map<String, Node> map;
    public int size = 0;

    public Cache() {
        map = new HashMap<>();
    }

    public void moveToFront(Node node) {

    }

    public void moveToFront(String query) {

    }

    /*Removes node from linked list*/
    public void removeFromLinkedList(Node node) {

    }

    public String[] getResults(String query) {
        if (!map.containsKey(query)) {
            return null;
        }
        Node node = map.get(query);
        moveToFront(node);/*update freshness*/
        return node.results;
    }

    public void insertResults(String query, String[] results) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            node.results = results;
            moveToFront(node); // update freshness
            return;
        }

        Node node = new Node(query, results);
        moveToFront(node);
        map.put(query, node);
        if (size > MAX_SIZE) {
            map.remove(tail.query);
            removeFromLinkedList(tail);
        }
    }

    private static class Node {
        public String[] results;
        public String query;

        public Node(String query, String[] results) {
        }
    }

}
