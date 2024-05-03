import java.util.Scanner;

public class DijkstraMST {

    static final int INF = Integer.MAX_VALUE;

    static int minDistance(int dist[], boolean visited[], int V) {
        int minDist = INF, minIndex = -1;
        
        for (int i = 0; i < V; ++i) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void dijkstraMST(int graph[][], int V) {
        int parent[] = new int[V];
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; ++i) {
            dist[i] = INF;
            parent[i] = -1;
        }

        dist[0] = 0;

        for (int count = 0; count < V - 1; ++count) {
            int u = minDistance(dist, visited, V);
            visited[u] = true;

            for (int i = 0; i < V; ++i) {
                if (!visited[i] && graph[u][i] != 0 && dist[u] != INF && dist[u] + graph[u][i] < dist[i]) {
                    parent[i] = u;
                    dist[i] = dist[u] + graph[u][i];
                }
            }
        }

        System.out.println("Edge   Weight");
        for (int i = 1; i < V; ++i)
            System.out.println(parent[i] + " - " + i + "   " + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[100][100];

        System.out.println("Enter the adjacency matrix representing the graph:");
        for (int i = 0; i < V; ++i)
            for (int j = 0; j < V; ++j)
                graph[i][j] = scanner.nextInt();

        dijkstraMST(graph, V);

        scanner.close();
    }
}

// Enter the number of vertices: 4
// Enter the adjacency matrix representing the graph:
// 0 3 0 6
// 3 0 1 2
// 0 1 0 0
// 6 2 0 0
// Edge   Weight
// 0 - 1   3
// 1 - 2   1
// 1 - 3   2







// import java.util.Scanner;

// public class DijkstraMST {

//     static final int INF = Integer.MAX_VALUE; // Define a constant representing infinity

//     // Function to find the vertex with minimum distance value from the set of vertices not yet included in MST
//     static int minDistance(int dist[], boolean visited[], int V) {
//         int minDist = INF, minIndex = -1; // Initialize minDist to infinity and minIndex to -1
//         for (int v = 0; v < V; ++v) { // Iterate over all vertices
//             if (!visited[v] && dist[v] < minDist) { // If vertex v is not visited and its distance is smaller than minDist
//                 minDist = dist[v]; // Update minDist to dist[v]
//                 minIndex = v; // Update minIndex to v
//             }
//         }
//         return minIndex; // Return the index of the vertex with minimum distance
//     }

//     // Function to print the MST
//     static void printMST(int parent[], int graph[][], int V) {
//         System.out.println("Edge   Weight"); // Print header for the MST output
//         for (int i = 1; i < V; ++i) // Iterate over all vertices except the first one (0)
//             System.out.println(parent[i] + " - " + i + "   " + graph[i][parent[i]]); // Print the edge and its weight
//     }

//     // Function to find the MST using Dijkstra's algorithm
//     static void dijkstraMST(int graph[][], int V) {
//         int parent[] = new int[V]; // Array to store the parent of each vertex in the MST
//         int dist[] = new int[V]; // Array to store the distance of each vertex from the source vertex
//         boolean visited[] = new boolean[V]; // Array to mark visited vertices

//         // Initialize dist[] and parent[] arrays
//         for (int i = 0; i < V; ++i) {
//             dist[i] = INF; // Set distance to infinity
//             parent[i] = -1; // Initialize parent to -1
//         }

//         dist[0] = 0; // Distance from source vertex to itself is 0

//         // Iterate V-1 times to find the shortest path for all vertices
//         for (int count = 0; count < V - 1; ++count) {
//             int u = minDistance(dist, visited, V); // Get the vertex with minimum distance
//             visited[u] = true; // Mark vertex u as visited

//             // Update the distance and parent of adjacent vertices of u
//             for (int v = 0; v < V; ++v) {
//                 if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
//                     parent[v] = u; // Set the parent of v to u
//                     dist[v] = dist[u] + graph[u][v]; // Update the distance of v
//                 }
//             }
//         }

//         printMST(parent, graph, V); // Print the MST
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the number of vertices: ");
//         int V = scanner.nextInt(); // Input the number of vertices

//         int graph[][] = new int[100][100]; // Initialize the adjacency matrix

//         // Input the adjacency matrix representing the graph
//         System.out.println("Enter the adjacency matrix representing the graph:");
//         for (int i = 0; i < V; ++i)
//             for (int j = 0; j < V; ++j)
//                 graph[i][j] = scanner.nextInt();

//         dijkstraMST(graph, V); // Find the MST using Dijkstra's algorithm

//         scanner.close(); // Close the scanner
//     }
// }

