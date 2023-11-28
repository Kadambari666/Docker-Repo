package CoreJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.print("Depth-First Search starting from vertex 0: ");
        graph.DFS(0);
    }
}
