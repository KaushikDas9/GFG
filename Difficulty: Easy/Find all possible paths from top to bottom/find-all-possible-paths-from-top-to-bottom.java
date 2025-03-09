//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] grid = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findAllPossiblePaths(a[0],a[1], grid);
            
            IntMatrix.print(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
    
    public static void find( int row,int col,int[][] arr ,ArrayList<Integer> s,ArrayList<ArrayList<Integer>> ans  ) { 
        
        int n = arr.length;
        int m = arr[0].length;
        
        if( row<0 || col<0 || row>n-1 || col >m-1 ) return ;
        if( row==n-1 && col==m-1 ) { 
            s.add(arr[row][col]);
            ans.add(new ArrayList<>(s) );
            s.remove(s.size()-1);
            return;
        }
        
        
        s.add(arr[row][col]);
        // 00 01 (0,+1)
        // 10 11 ( +1,0 )
        //right
        find(row+1,col,arr,s,ans);
        // s.remove(s.size()-1);
        // s.add(arr[row][col]);
        find(row,col+1,arr,s,ans);
        s.remove(s.size()-1);
        
    }
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(0,0,grid,new ArrayList<Integer>(),ans);    
        return ans;
    }
}
        
