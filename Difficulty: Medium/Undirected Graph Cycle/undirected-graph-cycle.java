//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    
    public static boolean dfs (ArrayList<ArrayList<Integer>> adj,int node,int[] vis,int parent) {
            
            vis[node]=1;
            
            for ( int i:adj.get(node) ) {
                
                if( vis[i] != 1) {
                    if(dfs( adj,i,vis,node )) return true;
                }
                else if( i!=parent  ) return true;
            }
            return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        int v = adj.size();
        int[] vis = new int[v]; 
        
        for ( int i=0;i<v;i++ ) {
                if( vis[i]==0  ) {
                if(dfs(adj,i,vis,-1)) return true;
                    
                }
        }    
            
        return false;
        
    }
}