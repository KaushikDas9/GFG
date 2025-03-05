//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int find( int row,int col,int[][] arr,Integer[][] dp ) {
        
        int n=arr.length;
        int m=arr[0].length;
        
        if( row>n-1 || col>m-1) return 0;
        if( dp[row][col] != null ) return dp[row][col];
        
        int ans=0;
        for( int i=0;i<3;i++ ) { 
            
            if( i != col ) { 
                ans = Math.max( ans,(find( row+1,i,arr,dp )+arr[row][col]) ) ;
            }
        }
        
        return dp[row][col]=ans;
        
    }
    public int maximumPoints(int arr[][]) {
        // code here
        
        int n=arr.length;
        int m=arr[0].length;
        Integer[][] dp = new Integer[n+1][m+1];
        
        
        int ans=0;
        for( int i=0;i<3;i++ ) { 
            
                ans = Math.max( ans,(find( 0,i,arr,dp )) ) ;
            
        }
        
        return ans;
        
    }
}