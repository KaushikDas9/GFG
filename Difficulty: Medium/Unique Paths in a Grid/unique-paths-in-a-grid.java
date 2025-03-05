//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int mod = (int)(1e9+7);
    
    public static int find ( int row,int col,int[][] grid,Integer[][] dp ) { 
        
        int n=grid.length;
        int m=grid[0].length;
        if( row>n-1||col>m-1 ) return 0;
        if( n-1==row&&m-1==col ) return 1;
        if( dp[row][col]!=null ) return (dp[row][col])%mod;
        // 00 01  0,+1
        // 10 11  +1,0
        int a=0,b=0;
        if( col+1<=m-1&&grid[row][col+1] == 1 ) a=find( row,col+1,grid,dp );
        if( row+1<=n-1&&grid[row+1][col] == 1 ) b=find( row+1,col,grid,dp );
        
        return dp[row][col]=(a+b)%mod;
    }
    
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        if( grid[0][0] == 0 ) return 0;
        Integer[][] dp = new Integer[n][m];
        return find(0,0,grid,dp);
    }
};