//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        if(x.length()==0) return false;
        
        Stack<String> ans = new Stack<>();
        ans.push(String.valueOf(x.charAt(0)));
        
        for(int i=1 ;i<x.length() ;i++ )
        {
            if(!ans.empty())
            {
                String temp =ans.peek();
                // System.out.println(temp +" " + "  " +String.valueOf(x.charAt(i)));
     
                if( (temp.equals("[") && String.valueOf(x.charAt(i)).equals("]") )  || (temp.equals("(") && String.valueOf(x.charAt(i)).equals(")") ) || (temp.equals("{") && String.valueOf(x.charAt(i)).equals("}") ) ) { ans.pop();}
                 
                else {ans.push(String.valueOf(x.charAt(i)));}
            }
            else
            {ans.push(String.valueOf(x.charAt(i)));}
        }
        if(ans.empty()) return true;
        else return false;
    }
}
