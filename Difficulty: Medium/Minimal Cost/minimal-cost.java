//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    
    
    public static int find( int n,int k,int[] arr,int[] dp ) { 
        
        if( n==0 ) return 0;
        if( dp[n]!=-1 ) return dp[n];
        
        int ans = Integer.MAX_VALUE;
        for( int i=1;i<=k;i++ ) { 
            
            
            if( n-i>=0 )  { 
                ans=Math.min(ans,find( n-i,k,arr,dp )+ Math.abs( arr[n]-arr[n-i] )) ;    
            }
        }
        
        return dp[n]=ans;
    }
    
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n= arr.length;
        int[] dp = new int[n+1];
        for ( int i=0;i<n+1;i++ ) dp[i]=-1;
        return find( n-1,k,arr,dp );
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends