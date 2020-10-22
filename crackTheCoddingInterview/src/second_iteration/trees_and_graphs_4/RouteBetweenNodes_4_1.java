package second_iteration.trees_and_graphs_4;

import second_iteration.trees_and_graphs_4.Graph.Node;
import second_iteration.trees_and_graphs_4.Graph.State;

import java.util.ArrayDeque;
import java.util.Deque;

public class RouteBetweenNodes_4_1 {

    <T> boolean pathExists(Graph<T> graph, Node<T> start, Node<T> end) {
        if (start == end) {
            return true;
        }

        for (Node<T> node : graph.nodes) {
            node.nodeState = State.Unvisited;
        }
        Deque<Node<T>> queue = new ArrayDeque<>();
        start.nodeState = State.Visiting;
        queue.addLast(start);
        Node<T> next;
        while (!queue.isEmpty()) {
            next = queue.removeFirst();
            if (next != null) {
                for (Node<T> nextChild : next.children) {
                    if (nextChild.nodeState == State.Unvisited) {
                        if (nextChild == end) {
                            return true;
                        } else {
                            nextChild.nodeState = State.Visiting;
                            queue.addLast(nextChild);
                        }
                    }

                }
            }
            next.nodeState = State.Visited;
        }
        return false;
    }

}
