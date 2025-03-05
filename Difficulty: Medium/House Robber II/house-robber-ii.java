//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int find( int n,int end,int[] arr,int[] dp ) { 
        
        if( n<end ) return 0;
        if ( n==end ) return dp[end]=arr[end];
        if( dp[n]!=-1 ) return dp[n];
        
        int a = find( n-2,end,arr,dp ) + arr[n] ;
        int b = find( n-1,end,arr,dp  );
        
        return dp[n] = Math.max(a,b);
        
    }
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        int[] dp = new int[n+1];
        for ( int i=0;i<n+1;i++) dp[i]=-1;
        
        int a =find(n-1,1,arr,dp );
        for ( int i=0;i<n+1;i++) dp[i]=-1;
        int b= find(n-2,0,arr,dp );
        return Math.max(a,b);
        
    }
}
