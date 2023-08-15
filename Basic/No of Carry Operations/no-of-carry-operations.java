//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S[] = read.readLine().split(" ");
            
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();

            System.out.println(ob.countCarry(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countCarry(Long A , Long B){
        // code here
        
        String s1 = String.valueOf(A);
        String s2 = String.valueOf(B);
        int carry=0,count=0;
        for( int i=s1.length()-1;i>=0;i-- ) {
            int temp1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
            int temp2 = Integer.parseInt(String.valueOf(s2.charAt(i)));
            
            if(temp1+temp2+carry>=10) { count++;carry=1;}
            else{carry=0;}
        }
        return count;
    }
};