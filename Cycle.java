import java.io.*;
import java.util.*;

class Cycle {

    // Graph
    static LinkedList<Integer>[] adj;

    // Visited
    static boolean[] visited;

    // Check for cycles
    static boolean hasCycle(int index) {

        // Ever been here before?
        if (visited[index])
            return true;

        // Mark as visited
        visited[index] = true;

        // DFS
        for (Integer a : adj[index])
            if (hasCycle(a))
                return true;

        // Found none
        return false;
    }

    // Runner
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        // Get input file
        File inputFile = new File("./input.txt");

        // Open read stream
        Scanner sc = new Scanner(inputFile);

        // Vertices / Edges
        int V = sc.nextInt();
        int E = sc.nextInt();

        // Set vertices
        adj = new LinkedList[V + 1];
        visited = new boolean[V + 1];

        // Create vertices
        for (int i = 1; i <= V; i++) {
            adj[i] = new LinkedList<>();
        }

        // Create edges
        for (int i = 0; i < E; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();

            adj[f].add(t);
        }

        // Close read stream
        sc.close();

        // Exceptions
        if (V == 0) {
            System.out.println("Acyclic");
            return;
        }

        // Checks for cycles
        for (int i = 1; i <= V; i++) {
            if (hasCycle(i)) {
                System.out.println("The graph is cyclic!");
                return;
            }
        }

        // None?
        System.out.println("The graph is acyclic!");
    }
}
