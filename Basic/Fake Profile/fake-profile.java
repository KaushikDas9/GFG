//{ Driver Code Starts
//Initial Template for Java

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
                    String a = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.solve(a));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean isVowel(char str) {
        if(str== 'a'||str== 'e'||str== 'i'||str== 'o'||str== 'u') return true;
        return false;
    }
    public String solve(String a)
    {
        //code here
        int count=0;
        HashSet<Character> set = new HashSet<>();
        for( int i=0;i<a.length();i++ ) {
            
            if( !isVowel(a.charAt(i)) && !set.contains(a.charAt(i)) ) { count++;
                // System.out.println(a.charAt(i));
            }
            set.add(a.charAt(i));
        }
        // System.out.println(count);
        if(count%2 ==0 ) return "SHE!";
        return "HE!";
    }
}