//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int vertices = Integer.parseInt(read.readLine());
            int edges = Integer.parseInt(read.readLine());

            for (int i = 0; i < vertices; i++) adj.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edges; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
            }

            ArrayList<Integer> res = new Solution().topologicalSort(adj);

            if (check(adj, vertices, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj , int node , int[] vis , Stack<Integer> s) { 
        
        vis[node]=1;
        
        for( int i:adj.get(node) ) {
            if( vis[i]==0 ) {
                dfs(adj,i,vis,s);    
            }
        }
        
        s.add(node);
        
    }
    
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        
        int v = adj.size();
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans  = new ArrayList<>();
        int[] vis = new int[v];
        
        for( int i=0;i<v;i++) {
            
            if( vis[i]==0 ) {
                dfs(adj,i,vis,s);
            }
            
        }
        
        while( !s.isEmpty() ) ans.add(s.pop());
        return ans;
    }
}