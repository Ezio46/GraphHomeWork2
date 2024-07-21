import java.util.*;

public class Graph2 {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph2() {
        this.adjacencyList = new HashMap<>();
        for (int i = 1; i <= 10; i++) { 
            adjacencyList.put(i, new ArrayList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(2).add(4);
        adjacencyList.get(2).add(5);
        adjacencyList.get(3).add(6);
        adjacencyList.get(4).add(7);
        adjacencyList.get(5).add(8);
        adjacencyList.get(6).add(9);
        adjacencyList.get(7).add(10);
        adjacencyList.get(8).add(10);
    }

    // Обход в ширину (BFS)
    public void breadthFirstSearch(int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Обход в глубину (DFS)
    public void depthFirstSearch(int startNode) {
        Set<Integer> visited = new HashSet<>();
        depthFirstSearchRecursive(startNode, visited);
    }

    private void depthFirstSearchRecursive(int currentNode, Set<Integer> visited) {
        visited.add(currentNode);
        System.out.print(currentNode + " ");

        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited.contains(neighbor)) {
                depthFirstSearchRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph2 graph = new Graph2();

        System.out.println("Обход в ширину:");
        graph.breadthFirstSearch(1); // Начинаем обход с вершины 1

        System.out.println("\nОбход в глубину:");
        graph.depthFirstSearch(1); // Начинаем обход с вершины 1
    }
}
