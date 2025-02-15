//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int v = adj.size();
        int[] ans = new int[v];
        
        Arrays.fill(ans, -1);
        
       
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        
      
        ans[src] = 0;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int node = temp[0];
            int time = temp[1];
            
      
            for (int neighbor : adj.get(node)) {
                int newDistance = time + 1;
                
           
                if (ans[neighbor] == -1 ) {
                    ans[neighbor] = newDistance;
                    q.add(new int[]{neighbor, newDistance});
                }
            }
        }
        
        return ans;
    }
}
