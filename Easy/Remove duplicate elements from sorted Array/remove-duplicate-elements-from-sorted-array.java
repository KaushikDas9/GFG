//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int A[],int N){
        // code here
        // HashSet<Integer> set  = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();        
        for( int i=0;i<N-1;i++ ) {
            
            if(A[i] != A[i+1] ) list.add(A[i]) ;
            
        }
        list.add(A[N-1]) ;
         for( int i=0;i<list.size();i++ ) {
            
            A[i] =list.get(i);
            
        }
        
        // System.out.println(list);
        return list.size();
    }
}