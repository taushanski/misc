package first_iteration.system_design;

import java.util.*;

public class SocialNetwork {

    /*
     The runtime of this algorithm is O(b^(d/2)) where b is the number of adjacent nodes  and d is the distance of destination
     */
    static List<Person> findPathBidirectionalBFS(Map<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            /* Search out from source*/
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
            /* Search out from destination*/
            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }
        return null;
    }

    /*Search one level and return collision, if any.*/
    private static Person searchLevel(Map<Integer, Person> people, BFSData primary, BFSData secondary) {
        /*We only want to search one level at a time. Count how many nodes are
         *currently in the primary's level and only do that many nodes. We'll continue
         *to add nodes to the end.*/
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getID();

            /*check  if its already been visited.*/
            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            // Add friends to queue
            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }

    //Merge paths where searches met at connection.
    private static List<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection); // end1 -> source
        PathNode end2 = bfs2.visited.get(connection); // end2 -> destination
        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true);// reverse
        pathTwo.removeFirst();// remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }

    private static class Person {
        private final int id;
        private List<Integer> friends = new ArrayList<>();
        private String info;

        public Person(int id) {
            this.id = id;
        }

        public int getID() {
            return id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public void addFriend(int id) {
            friends.add(id);
        }

        public ArrayList<Integer> getFriends() {
            return null;
        }
    }

    private static class BFSData {
        Queue<PathNode> toVisit = new LinkedList<>();
        Map<Integer, PathNode> visited = new HashMap<>();

        public BFSData(Person root) {
            PathNode sourcePath = new PathNode(root, null);
            toVisit.add(sourcePath);
            visited.put(root.getID(), sourcePath);
        }


        public boolean isFinished() {
            return toVisit.isEmpty();
        }

    }

    private static class PathNode {
        private Person person;
        private PathNode previousNode;

        public PathNode(Person p, PathNode previousNode) {
            person = p;
            this.previousNode = previousNode;
        }

        public Person getPerson() {
            return person;
        }

        public LinkedList<Person> collapse(boolean startsWithRoot) {
            LinkedList<Person> path = new LinkedList<>();
            PathNode node = this;
            while (node != null) {
                if (startsWithRoot) {
                    path.addLast(node.person);
                } else {
                    path.addFirst(node.person);
                }
                node = node.previousNode;
            }
            return path;
        }
    }

    private static class Server {
        Map<Integer, Machine> machines = new HashMap<>();
        Map<Integer, Integer> personToMachineMap = new HashMap<>();

        public Machine getMachineWithId(int machineId) {
            return machines.get(machineId);
        }

        public int getMachineIdForUser(int personId) {
            Integer machineId = personToMachineMap.get(personId);
            return machineId == null ? -1 : machineId;
        }

        public Person getPersonWithID(int personID) {
            Integer machineID = personToMachineMap.get(personID);
            if (machineID == null) {
                return null;
            }

            Machine machine = getMachineWithId(machineID);
            if (machine == null) {
                return null;
            }

            return machine.getPersonWithID(personID);
        }

    }

    private static class Machine {
        private Map<Integer, Person> people = new HashMap<>();

        public Person getPersonWithID(int personID) {
            return people.get(personID);
        }
    }

}
