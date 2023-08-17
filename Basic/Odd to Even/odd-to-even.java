//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.makeEven(str));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String makeEven(String s)
    {
        //code here.
         int temp=-1;
         int com =Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
         int maxi= Integer.MIN_VALUE;
        
        for( int i=0;i<s.length()-1;i++ ) {
            
            int num=Integer.parseInt(String.valueOf(s.charAt(i)));
            
            if(num%2==0  ) {
               if( com>=num ) { temp=i; break; }
               temp=i;
            }
            
        }
        
        
        StringBuilder ans = new StringBuilder(s);
        
        if( temp ==-1 ) return ans.toString();
        
        ans.setCharAt(temp, s.charAt(s.length()-1));
        ans.setCharAt(s.length()-1, s.charAt(temp));
        return ans.toString();
        
        
    }
}