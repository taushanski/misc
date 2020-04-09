package trees_and_graphs;

import java.util.Collection;
import java.util.HashMap;

public class ProjectBuildOrder_4_7_s1 {

    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
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

    private Project[] orderProjects(Collection<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            // check for circular dependency
            if (current == null) {
                return null;
            }

            Collection<Project> currentChildren = current.getChildren();
            for (Project nextChild : currentChildren) {
                nextChild.decrementDependencies();
            }

            endOfList = addNonDependent(order, currentChildren, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    private int addNonDependent(Project[] order, Collection<Project> projects, int offset) {
        for (Project nextProject : projects) {
            if (nextProject.getDependencies() == 0) {
                order[offset] = nextProject;
                offset++;
            }
        }
        return offset;
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

    //TODO
    static class Project {

        private HashMap<String, Project> children = new HashMap<>();
        private final String name;
        private int dependencies = 0;


        public Project(String name) {
            this.name = name;
        }

        public void addNeighbor(Project neighbor) {
            if (!children.containsKey(neighbor.getName())) {
                children.put(neighbor.getName(), neighbor);
                neighbor.incrementDependencies();
            }
        }

        private void incrementDependencies() {
            dependencies++;
        }

        public int getDependencies() {
            return dependencies;
        }

        private String getName() {
            return this.name;
        }

        public Collection<Project> getChildren() {
            return children.values();
        }

        public void decrementDependencies() {
            dependencies--;
        }
    }
}
