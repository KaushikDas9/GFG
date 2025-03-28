//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static int find( int i,int j,int[] arr,Integer[][] dp ) { 
        
        if ( i==j ) return 0;
        if( dp[i][j] != null ) return dp[i][j];
        
        int mini = (int)1e9;
        for ( int k=i;k<j;k++ ) { 
            
            int step = arr[i-1]*arr[k]*arr[j] + 
                    find( i,k,arr,dp ) + find( k+1,j,arr,dp ) ;
                    
            mini = Math.min(mini,step);
        }
        
        return dp[i][j]=mini;
        
    }
    
    static int matrixMultiplication(int arr[]) {
        
        Integer[][] dp = new Integer[arr.length][arr.length];
        return find(1,arr.length-1,arr,dp);
    }
    
    
    
}