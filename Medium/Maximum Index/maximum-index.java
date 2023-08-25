//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int N=n;
         int pre[] = new int[N];
        pre[0] = arr[0];
          int suff[] = new int[N];
        suff[N-1] = arr[N-1];
        
        for( int i=1;i<N;i++) {
            
            pre[i]=Math.min(pre[i-1],arr[i]);
            suff[N-i-1] = Math.max(suff[N-i],arr[N-i-1]);
        }
        
        int i=0,j=0,ans=0;
        
        while(j<N) {
            
            if( suff[j] >= pre[i] ) {
                ans=Math.max(ans,(j-i));
                j++;
            }
            else {
                i++;
            }
        }
        
        return ans;
    }
}