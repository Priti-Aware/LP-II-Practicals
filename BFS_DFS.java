/*
Practical No: 01
Name: Aware Priti Balkrushna
Class:  TE    Division: B    Roll No: 07   
Branch: Computer Engineering
 */

import java.util.*;

public class BFS_DFS {
    static final int MAX_NODES = 100; // Maximum number of nodes in the graph
    static int[][] graph = new int[MAX_NODES][MAX_NODES]; // Adjacency matrix representing the graph
    static int numNodes; // Number of nodes in the graph

    // Queue class for BFS traversal
    static class Queue {
        int[] queue;
        int front, rear, size;

        // Constructor to initialize the queue with a given capacity
        public Queue(int capacity) {
            queue = new int[capacity];
            front = rear = size = 0;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check if the queue is full
        public boolean isFull() {
            return size == queue.length;
        }

        // Add an item to the rear of the queue (enqueue operation)
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full!");
                return;
            }
            queue[rear] = item;
            rear = (rear + 1) % queue.length;
            size++;
        }

        // Remove and return the item from the front of the queue (dequeue operation)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1; // or throw an exception
            }
            int item = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return item;
        }
    }

    // Stack class for DFS traversal
    static class Stack {
        int[] stack;
        int top;

        // Constructor to initialize the stack with a given capacity
        public Stack(int capacity) {
            stack = new int[capacity];
            top = -1;
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        // Check if the stack is full
        public boolean isFull() {
            return top == stack.length - 1;
        }

        // Push an item onto the stack
        public void push(int item) {
            if (isFull()) {
                System.out.println("Stack is full!");
                return;
            }
            stack[++top] = item;
        }

        // Pop and return the item from the top of the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1; // or throw an exception
            }
            return stack[top--];
        }
    }

    // Breadth-First Search traversal
    static void bfs(int start) {
        boolean[] visited = new boolean[MAX_NODES]; // Array to track visited nodes
        Queue q = new Queue(MAX_NODES); // Create a new queue for BFS
        q.enqueue(start); // Enqueue the starting node
        visited[start] = true; // Mark the starting node as visited
        System.out.print("BFS Traversal: ");
        while (!q.isEmpty()) {
            int current = q.dequeue(); // Dequeue a node
            System.out.print(current + " "); // Print the dequeued node
            // Explore adjacent nodes
            for (int i = 0; i < numNodes; ++i) {
                if (graph[current][i] != 0 && !visited[i]) {
                    q.enqueue(i); // Enqueue adjacent unvisited nodes
                    visited[i] = true; // Mark them as visited
                }
            }
        }
        System.out.println();
    }
    // Depth-First Search traversal
    static void dfs(int start) {
        boolean[] visited = new boolean[MAX_NODES]; // Array to track visited nodes
        Stack stack = new Stack(MAX_NODES); // Create a new stack for DFS
        stack.push(start); // Push the starting node onto the stack
        visited[start] = true; // Mark the starting node as visited
        System.out.print("DFS Traversal: ");
        while (!stack.isEmpty()) {
            int current = stack.pop(); // Pop a node from the stack
            System.out.print(current + " "); // Print the popped node
            // Explore adjacent nodes
            for (int i = 0; i < numNodes; ++i) {
                if (graph[current][i] != 0 && !visited[i]) {
                    stack.push(i); // Push adjacent unvisited nodes onto the stack
                    visited[i] = true; // Mark them as visited
                  }
    }
   }
        System.out.println();
  }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, startNode;

        System.out.print("Enter the number of nodes: ");
        numNodes = scanner.nextInt(); // Read the number of nodes from the user

        System.out.println("Enter the adjacency matrix:");
        // Read the adjacency matrix from the user
        for (int i = 0; i < numNodes; ++i) {
            for (int j = 0; j < numNodes; ++j) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Menu for user interaction
        do {
            System.out.println("Menu:");
            System.out.println("1. BFS Traversal");
            System.out.println("2. DFS Traversal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Read user's choice

            switch (choice) {
                case 1:
                    System.out.print("Enter the starting node for BFS traversal: ");
                    startNode = scanner.nextInt();
                    bfs(startNode); // Perform BFS traversal
                    break;
                case 2:
                    System.out.print("Enter the starting node for DFS traversal: ");
                    startNode = scanner.nextInt();
                    dfs(startNode); // Perform DFS traversal
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();

        } while (choice != 3); // Continue until user chooses to exit

        scanner.close(); // Close the scanner
    }
}


 

/*
Enter the number of nodes: 5
Enter the adjacency matrix:
0 1 1 0 0
1 0 0 1 1
1 0 0 0 1
0 1 0 0 0
0 1 1 0 0

Menu:
1. BFS Traversal
2. DFS Traversal
3. Exit
Enter your choice: 1
Enter the starting node for BFS traversal: 0
BFS Traversal: 0 1 2 3 4 

Menu:
1. BFS Traversal
2. DFS Traversal
3. Exit
Enter your choice: 2
Enter the starting node for DFS traversal: 0
DFS Traversal: 0 2 4 3 1 

Menu:
1. BFS Traversal
2. DFS Traversal
3. Exit
Enter your choice: 3
Exiting program...

 */