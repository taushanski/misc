package first_iteration.trees_and_graphs;

import first_iteration.trees_and_graphs.ProjectBuildOrder_4_7_dfs.Project.State;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

public class ProjectBuildOrder_4_7_dfs {

    Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdje(first, second);
        }

        return graph;
    }

    private Stack<Project> orderProjects(Collection<Project> projects) {

        Stack<Project> stack = new Stack<>();
        for (Project nextProject : projects) {
            if (nextProject.getState() == State.BLANK) {
                if (!doDFS(nextProject, stack)) {
                    return null;// we found a cycle so we have to terminate
                }
            }
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == State.PARTIAL) {
            return false;// Cycle
        }

        if (project.getState() == State.BLANK) {
            project.setState(State.PARTIAL);
            Collection<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(State.COMPLETED);
            stack.push(project);
        }
        return true;

    }


    static class Graph {

        private HashMap<String, Project> map = new HashMap<>();


        public Project getOrCreateNode(String name) {
            Project resultProject = map.get(name);
            if (resultProject == null) {
                resultProject = new Project(name);
                map.put(name, resultProject);
            }
            return resultProject;
        }

        public void addEdje(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public Collection<Project> getNodes() {
            return map.values();
        }
    }

    static class Project {

        private HashMap<String, Project> children = new HashMap<>();
        private final String name;
        private State state = State.BLANK;

        public Project(String name) {
            this.name = name;
        }

        public void addNeighbor(Project neighbor) {
            if (!children.containsKey(neighbor.getName())) {
                children.put(neighbor.getName(), neighbor);
            }
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        private String getName() {
            return this.name;
        }

        public Collection<Project> getChildren() {
            return children.values();
        }

        public enum State {
            COMPLETED,
            PARTIAL,
            BLANK
        }
    }
}
