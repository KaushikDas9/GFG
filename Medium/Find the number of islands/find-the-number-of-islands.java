//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair {
    
    int first ;
    int second  ;
    
    Pair( int first  , int second ) {
        this.first = first ;
        this.second = second;
    }
}


class Solution {
  
      public static void bfs( int ro , int co , int[][] vis , char[][] grid ) { 
          
          Queue<Pair> queue = new LinkedList<>();
          
          int n = grid.length ;
          int m = grid[0].length ; 
          queue.add(new Pair(ro ,co ));
          
          while ( !queue.isEmpty() ) { 
              int row = queue.peek().first;
              int col = queue.peek().second;
              queue.remove();
              
             for( int i = -1 ;i<=1 ;i++ ) { 
                 for( int j= -1 ;j<=1;j++  ) {
                     
                     int nrow = row + i ;
                     int ncol = col + j ;
                     
                     if( nrow >=0 && nrow <n  && ncol >=0 && ncol<m && vis[ nrow ][ ncol ] == 0 && grid[nrow][ncol] == '1' ) {
                          
                           vis[ nrow ][ ncol ] = 1 ;
                           queue.add( new Pair( nrow,ncol ) );
                     }
                     
                 }
             }
             
          }
      }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int row = grid.length ; 
        int col = grid[0].length ;
        
        int[][] vis = new int[row][col];
        int count=0 ;
        //Chaking Where is Land and Water 
        
        for( int  i=0 ; i<row ; i++ ) {
            
            for( int j=0 ; j<col ; j++ ) { 
                
                if( vis[i][j] != 1 && grid[i][j] == '1' )  { 
                    count++;
                     bfs( i , j , vis , grid ) ; // Akane
                }    
            }
        }
        
        return count ;
    }
}