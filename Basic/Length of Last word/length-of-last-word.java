//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            int ans = ob.findLength(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findLength(String s) 
    { 
        // code here
        // int count =0 ;
        // for( int i=s.length()-1;i>=0;i-- ) {
            
        //     if(s.charAt(i) == ' ' ) return count;
        //     count++;
            
        // }
        //   return count; 
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ')
                break;
            sb.append(s.charAt(i));
        }
        return sb.length();
    }
}