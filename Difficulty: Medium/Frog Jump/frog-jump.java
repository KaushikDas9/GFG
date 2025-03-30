//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends



// User function Template for Java
class Solution {
    public int minCost(int[] height) {
        int n = height.length;
        if (n == 1) return 0;
        
        int[] dp = new int[n];

        // return findMinCost(height, n - 1, dp
        
        dp[0]=0;dp[1]= Math.abs(height[1] - height[0]);
            
        for ( int i=2;i<n;i++ ) { 
            int l =  Math.abs(height[i] - height[i-1]) + dp[i-1];
            int r =  Math.abs(height[i] - height[i-2]) + dp[i-2];
            dp[i]=Math.min(l,r);
        }
        
        return dp[n-1];
    }

    private int findMinCost(int[] height, int i, int[] dp) {
        
        if (i == 0) return 0;

        if (i == 1) return Math.abs(height[1] - height[0]);


        if (dp[i] != -1) return dp[i];

        int jump1 = findMinCost(height, i - 1, dp) + Math.abs(height[i] - height[i - 1]);


        int jump2 = findMinCost(height, i - 2, dp) + Math.abs(height[i] - height[i - 2]);


        dp[i] = Math.min(jump1, jump2);

        return dp[i];
    }
}


//{ Driver Code Starts.

// } Driver Code Ends