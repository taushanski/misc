package first_iteration.trees_and_graphs;

import first_iteration.trees_and_graphs.Graph.Node;
import first_iteration.trees_and_graphs.Graph.State;

import java.util.LinkedList;
import java.util.Queue;

public class GraphPathExists_4_1<T> {

    // BFS
    boolean routeExists(Graph<T> graph, Node<T> start, Node<T> end) {
        if (start == end) {
            return true;
        }

        Queue<Node<T>> queue = new LinkedList<>();

        for (Node<T> node : graph.nodes) {
            node.nodeState = State.Unvisited;
        }

        start.nodeState = State.Visiting;
        queue.add(start);
        Node nextNode;
        while (!queue.isEmpty()) {
            nextNode = queue.remove();
            if (nextNode != null) {
                for (Node<T> nextAdjecent : nextNode.children) {
                    if (nextAdjecent.nodeState == State.Unvisited) {
                        if (nextAdjecent == end) {
                            return true;
                        } else {
                            queue.add(nextAdjecent);
                            nextAdjecent.nodeState = State.Visiting;
                        }
                    }
                }
                nextNode.nodeState = State.Visited;
            }
        }
        return false;
    }
}
