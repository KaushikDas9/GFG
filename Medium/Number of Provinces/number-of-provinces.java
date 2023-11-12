//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    public static void dfs( int vertex , int[] vis , ArrayList<ArrayList<Integer>> adj ) 
    {  
        vis[vertex] = 1 ; 
        for( int i=0 ; i<adj.get(vertex).size() ; i++) { 
            
            if(vis[ adj.get(vertex).get(i) ] != 1 ) { 
                dfs( adj.get(vertex).get(i) , vis , adj );
            }
            
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        
        ArrayList<ArrayList<Integer>> myAdjList = new ArrayList<>(); 
        
        for( int i = 0 ; i<adj.size() ; i++  ) { 
            myAdjList.add( new ArrayList<>() );
        }
         
         //Convert matrix to Adjeccy List
        for( int i = 0 ; i<adj.size() ; i++  ) {
            
             for( int j= 0 ; j<adj.get(i).size() ; j ++ ) {
                 
                if( adj.get(i).get(j) == 1  && i != j ) {
                    
                    myAdjList.get(i).add( j );
                    myAdjList.get(j).add( i );
                }
            }
        }
        
        int[] vis = new int[V+1];
        // vis[1] = 1; 
        int count=0; 
        for( int i=0 ; i<V ; i++ )  { 
             
             if( vis[ i ] != 1 )  { 
                 count++;
                 dfs( i , vis , myAdjList );
             }
        }
        
        
        return count;
    }
    
};