//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public static void find( int n,int[] arr,int tar,ArrayList<Integer> s, ArrayList<ArrayList<Integer>> ans ) {
        
        if( n<0 || tar<0 ) return ;
        if( tar==0 ) {
            if( !ans.contains(s) ) ans.add(new ArrayList<>(s));
        }
        
        
        s.add(arr[n]);
        if( tar-arr[n]>=0) find(n,arr,tar-arr[n],s,ans);
        s.remove(s.size()-1);
        find(n-1,arr,tar,s,ans);
        
    }
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        int[] arr = new int[n];
        for( int i=1;i<=n;i++ ) arr[i-1]=i;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find( arr.length-1,arr,n,new ArrayList<Integer>(),ans );
        
        return ans;
    }
}