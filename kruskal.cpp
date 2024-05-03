#include<iostream>

using namespace std;

const int MAX_VERTICES = 100;
const int MAX_EDGES = 10000;

struct Edge {
    int source, destination, weight;
};

void KruskalMST(Edge edges[], int V, int E) {
    int parent[MAX_VERTICES]; 
    for (int i = 0; i < V; ++i)
        parent[i] = i;

    Edge result[MAX_VERTICES]; 
    for (int i = 0; i < E - 1; ++i) {
        for (int j = 0; j < E - i - 1; ++j) {
            if (edges[j].weight > edges[j + 1].weight) {
                swap(edges[j], edges[j + 1]);
            }
        }
    }
   
    int e = 0;
    int i = 0; 

    while (e < V - 1 && i < E) {
        Edge next_edge = edges[i++];

        int x = next_edge.source;
        int y = next_edge.destination;

        while (parent[x] != x)
            x = parent[x];
        while (parent[y] != y)
            y = parent[y];

        if (x != y) {
            result[e++] = next_edge;
            parent[y] = x;          //merge
        }
    }

    cout << "Edges in the MST:" << endl;
    for (i = 0; i < e; ++i)
        cout << result[i].source << " - " << result[i].destination << "   Weight: " << result[i].weight << endl;
}

int main() {
    int V, E;
    cout << "Enter the number of vertices and edges: ";
    cin >> V >> E;
    Edge edges[MAX_EDGES];
    cout << "Enter the source, destination, and weight for each edge:" << endl;
    for (int i = 0; i < E; ++i)
        cin >> edges[i].source >> edges[i].destination >> edges[i].weight;

    KruskalMST(edges, V, E);
    return 0;
}
