/*
Practical No: 03
Name: Aware Priti Balkrushna
Class:  TE    Division: B    Roll No: 07   
Branch: Computer Engineering
 */

import java.util.Scanner;

public class Prims {
    static final int INF = Integer.MAX_VALUE;

    static int minWeightEdge(int weights[], boolean visited[], int V) {
        int minWeight = INF;
        int minIndex = -1;
        for (int i = 0; i < V; ++i) {
            if (!visited[i] && weights[i] < minWeight) {
                minWeight = weights[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void primMST(int graph[][], int V) {
        int parent[] = new int[V]; // To store the parent of each vertex
        int weights[] = new int[V]; // To store the weight of the minimum edge to connect each vertex
        boolean visited[] = new boolean[V]; // To track visited vertices

        for (int i = 0; i < V; ++i) {
            parent[i] = -1;
            weights[i] = INF;
            visited[i] = false;
        }

        weights[0] = 0;

        for (int i = 0; i < V - 1; ++i) {
            int u = minWeightEdge(weights, visited, V);
            visited[u] = true;
            for (int v = 0; v < V; ++v) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < weights[v]) {
                    parent[v] = u;
                    weights[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge   Weight");
        for (int i = 1; i < V; ++i)
            // System.out.println(parent[i] + " - " + i + "   " + graph[i][parent[i]]);
            System.out.println((parent[i]) + " - " + (i) + "   " + graph[i][parent[i]]);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V]; // Assuming a maximum of 100 vertices

        System.out.println("Enter the adjacency matrix representing the graph:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                graph[i][j] = scanner.nextInt();
            }
        }

        primMST(graph, V);

        scanner.close();
    }
}
