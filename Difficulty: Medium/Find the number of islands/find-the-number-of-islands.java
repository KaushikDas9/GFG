//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    
    
    public static void dfs ( char[][] grid , int[][] vis ,int row,int col ) {
        
        int n= grid.length;
        int m= grid[0].length;
        
        vis[row][col] = 1;
        
        // left,right,up,down,leftUpDia , rightUpDia , rightDownDia , leftDownDia
        int[][] dir = {{ 0,-1 },{ 0,+1 },{ -1,0 },{+1,0},
                            { -1,-1 },{ -1,+1 },{ +1,+1 },{ +1,-1 } };
        
        for ( int[] i:dir  ) {
            
            int nrow = row + i[0];
            int ncol = col + i[1];
            
            if( nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                vis[nrow][ncol]==0 && grid[nrow][ncol]=='1' ) {
                dfs(grid,vis,nrow,ncol);
            }
            
        }
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        
        int n= grid.length;
        int m= grid[0].length;
        
        int[][] vis = new int[n][m];
        
        int ans=0;
        for ( int i=0;i<n;i++ ) {
            for( int j=0;j<m;j++ ) { 
                
                if( vis[i][j] == 0 && grid[i][j]=='1' ) { 
                    ans++;
                    dfs(grid,vis,i,j);
                }
            }
        } 
        
        return ans;
    }
}