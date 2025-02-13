//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution {
    
    public static boolean dfs(int node, int[] vis, int[] recStack, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1; // Mark the node as visited
        recStack[node] = 1; // Mark the node as part of the current recursion stack
        
        // Traverse all adjacent nodes
        for (int i : adj.get(node)) {
            if (vis[i] == 0) { // If the adjacent node is not visited
                if (dfs(i, vis, recStack, adj)) {
                    return true; // Cycle detected
                }
            } else if (recStack[i] == 1) { // If the adjacent node is in the recursion stack
                return true; // Cycle detected
            }
        }
        
        recStack[node] = 0; // Remove the node from the recursion stack
        return false; // No cycle detected
    }
    
    // Function to detect cycle in a directed graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V]; // Visited array
        int[] recStack = new int[V]; // Recursion stack array
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) { // If the node is not visited
                if (dfs(i, vis, recStack, adj)) {
                    return true; // Cycle detected
                }
            }
        }
        
        return false; // No cycle detected
    }
}