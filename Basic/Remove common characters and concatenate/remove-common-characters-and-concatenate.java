//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t--!=0){
            String s1=in.next(),
                   s2=in.next();
            
            Solution obj = new Solution();
            
            System.out.println(obj.concatenatedString(s1,s2));
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1,String s2)
    {
        // Your code here
        String store= s1+s2;
        String ans = "";
        for(int i=0; i<store.length(); i++)
        {
            String temp = String.valueOf(store.charAt(i));
            // System.out.println(temp);
            if((s1.contains(temp)) && (s2.contains(temp)) ){}else ans += temp;
        }
        
        if(ans.length()==0) return "-1";
         return ans;
    }
}
