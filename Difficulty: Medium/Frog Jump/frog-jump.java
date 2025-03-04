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
        if (n == 0) return 0;

        // Initialize the memoization table with -1 (uncomputed)
        int[] dp = new int[n];
        for( int i=0;i<n;i++ ) dp[i]=-1;

        // Start the recursion from the last stair
        return findMinCost(height, n - 1, dp);
    }

    private int findMinCost(int[] height, int i, int[] dp) {
        // Base case: If we are at the first stair, the cost is 0
        if (i == 0) return 0;

        // If we are at the second stair, the cost is the absolute difference between the first and second stair
        if (i == 1) return Math.abs(height[1] - height[0]);

        // If the result is already computed, return it
        if (dp[i] != -1) return dp[i];

        // Calculate the cost of jumping from (i-1)th stair
        int jump1 = findMinCost(height, i - 1, dp) + Math.abs(height[i] - height[i - 1]);

        // Calculate the cost of jumping from (i-2)th stair
        int jump2 = findMinCost(height, i - 2, dp) + Math.abs(height[i] - height[i - 2]);

        // Store the minimum cost in the memoization table
        dp[i] = Math.min(jump1, jump2);

        return dp[i];
    }
}


//{ Driver Code Starts.

// } Driver Code Ends