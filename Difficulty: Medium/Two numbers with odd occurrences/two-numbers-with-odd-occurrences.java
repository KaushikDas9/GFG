//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N) {
        
        int num= 0;
        
        for( int i=0;i<N;i++ ) {
            num ^= Arr[i];
        }
        
        
        int rightMost = ( ( num&(num-1) )^num ) ;
        
        
        int x =0,y=0;
        
        for ( int i=0;i<N;i++ ) { 
            
            if( (Arr[i]&rightMost)!=0 ) {
                x ^= Arr[i];
            } else { 
                y ^= Arr[i];
            }
        }
        
        return new int[]{Math.max(x,y),Math.min(x,y)};
    }
}