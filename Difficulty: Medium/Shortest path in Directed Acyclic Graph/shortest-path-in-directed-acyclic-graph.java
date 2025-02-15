//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    
    // Helper function for topological sort
    public static void topoSort(List<List<int[]>> adj, int node, int[] vis, Stack<Integer> s) {
        vis[node] = 1;
        
        for (int[] neighbor : adj.get(node)) {
            if (vis[neighbor[0]] == 0) {
                topoSort(adj, neighbor[0], vis, s);
            }
        }
        
        s.push(node); // Add the node to the stack after visiting all its neighbors
    }
    
    // Function to find the shortest path in a DAG
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Initialize adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
        }
        
        // Perform topological sort
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V]; // Visited array for topological sort
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(adj, i, vis, s);
            }
        }
        
        // Initialize distance array
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE); // Set all distances to infinity
        ans[0] = 0; // Set the distance of the source node to 0
        
        // Process nodes in topological order
        while (!s.isEmpty()) {
            int temp = s.pop();
            
            // Update distances for all neighbors
            for (int[] neighbor : adj.get(temp)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                // Relaxation step
                // if( ans[temp] == Integer.MAX_VALUE) { 
                //     ans[v] = weight;
                // }
                
                if (ans[temp] != Integer.MAX_VALUE && ans[v] > ans[temp] + weight) {
                    ans[v] = ans[temp] + weight;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}