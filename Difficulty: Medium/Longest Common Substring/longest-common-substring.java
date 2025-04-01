//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int find( int i,int j,String s1, String s2,Integer[][] dp ) { 
        
        int n = s1.length(); 
        int m = s2.length();
        
        if( i==n || j==m ) return 0;
        if( dp[i][j] != null ) return dp[i][j];
        
        int ans=0,k=i,l=j;
        while ( k<n && l<m && s1.charAt(k)==s2.charAt(l)  ) { 
            ans++;k++;l++;
        }
        
        ans = Math.max( ans,find( i+1,j,s1,s2,dp) );
        ans = Math.max( ans,find( i,j+1,s1,s2,dp) );
        
        
        return dp[i][j]=ans;
        
    }
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length(); 
        int m = s2.length();
        Integer[][] dp = new Integer[n][m];
        return find(0,0,s1,s2,dp);
        
    }
}