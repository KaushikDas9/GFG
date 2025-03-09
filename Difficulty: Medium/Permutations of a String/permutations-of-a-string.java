//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    private void find(int n, char[] s, ArrayList<String> ans, HashSet<String> seen) {
        if (n == s.length) {
            String perm = new String(s);
            if (seen.add(perm)) { // Ensures unique permutations
                ans.add(perm);
            }
            return;
        }

        for (int i = n; i < s.length; i++) { 
            swap(s, n, i);
            find(n + 1, s, ans, seen);
            swap(s, n, i); // Backtrack
        }
    }
    
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> seen = new HashSet<>(); // To avoid duplicates
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // Sort to get lexicographical order naturally
        find(0, arr, ans, seen);
        return ans;
    }
}