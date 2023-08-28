//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        HashSet<Character> set = new HashSet<>();
        int maxlen=0,j=0;        
        for( int i=0;i<S.length();i++ ) {
            
            if(!set.contains(S.charAt(i)) ) { set.add(S.charAt(i));}
            else {
                maxlen = Math.max(maxlen, set.size());
                // System.out.println(set);
                while( S.charAt(j) != S.charAt(i) ){
                  set.remove(S.charAt(j++));
                }
                j++;
            }
        }
        maxlen = Math.max(maxlen, set.size());
        // System.out.println(set);
        return maxlen;
    }
}