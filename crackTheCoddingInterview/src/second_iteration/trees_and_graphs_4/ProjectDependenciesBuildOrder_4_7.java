package second_iteration.trees_and_graphs_4;

import java.util.List;

public class ProjectDependenciesBuildOrder_4_7 {

    public static class Graph {

        private List<Project> projects;

    }

    public static class Project {

        private String name;

        // the projects in this list depends on this project for their build
        private List<Project> dependencies;

        public Project(String name) {
            this.name = name;
        }

        public void addDependency(Project dependentProject) {
            dependencies.add(dependentProject);
        }
    }

}
