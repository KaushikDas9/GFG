//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static void find(int n ,int k , ArrayList<Integer> ds, int tar , ArrayList<ArrayList<Integer>> ans) {
         if( n == 11 ||  tar < 0 || k < 0  ) return ;
       
        if( tar==0 && k==0 ) {
            
            ans.add( new ArrayList<Integer>(ds));
            return;
        }
          
          
        
        ds.add(n);
        find(n+1,k-1,ds,tar-n,ans);
        ds.remove(ds.size()-1);
        
        find(n+1,k,ds,tar,ans);
        
        return ;
    }
    
    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        // if(K>N ) return ArrayList<ArrayList<Integer>>();
         
        find( 1 , K , new ArrayList<Integer>() , N , ans );
        return ans;
    } 
}