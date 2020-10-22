package first_iteration.trees_and_graphs;

public class Graph<T> {

    public Node<T>[] nodes;


    public static class Node<T> {
        public T data;
        public Node[] children;
        public State nodeState;
    }

    public enum State {
        Visited,
        Unvisited,
        Visiting
    }
}
