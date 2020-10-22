package second_iteration.trees_and_graphs_4;

public class Graph<T> {

    public Node<T>[] nodes;

    public static class Node<T> {

        public T data;

        public Node<T>[] children;

        public State nodeState;
    }

    public enum State {
        Visited,
        Unvisited,
        Visiting
    }

}
