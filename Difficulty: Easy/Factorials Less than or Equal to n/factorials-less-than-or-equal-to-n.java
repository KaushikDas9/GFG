//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    
    
  static void findFactorials(long n, long i, long factorial, ArrayList<Long> ans) {
        // Base case: if factorial exceeds n, stop recursion
        if (factorial > n) {
            return;
        }
        
        
        ans.add(factorial);
      
        findFactorials(n, i + 1, factorial * (i + 1), ans);
    }
  static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> ans = new ArrayList<Long>();
        findFactorials(n, 1, 1, ans);
        return ans;
    }
    
    
}