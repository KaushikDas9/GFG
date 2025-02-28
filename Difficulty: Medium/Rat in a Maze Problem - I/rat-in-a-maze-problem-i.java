//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static void find( int row,int col,ArrayList<String> ans,ArrayList<ArrayList<Integer>> arr,
                int[][] vis, String str  ) {
                    
        int n = arr.size();
        
        if( row==n-1 && col==n-1) {
            ans.add(str);
            return ;
        }
        
        // D, L, R, U
        int[][] dir = {{+1, 0}, {0, -1}, {0, +1}, {-1, 0}};
        

        for ( int[] i: dir ) { 
            int newRow = i[0]+row;
            int newCol = i[1]+col;
            
            if( newRow>=0 && newRow<=n-1 && newCol>=0 && newCol<=n-1
                && vis[newRow][newCol]!=1 && arr.get(newRow).get(newCol) ==1  ) { 
                
                if( i[0]==-1&&i[1]==0 ) str += "U";
                else if( i[0]==+1&&i[1]==0 ) str += "D";
                else if( i[0]==0&&i[1]==-1 ) str += "L";
                else str +="R";
                
                vis[newRow][newCol] = 1;
                find( newRow,newCol,ans,arr,vis,str );
                vis[newRow][newCol] = 0;
                str = str.substring(0, str.length()-1 );
            }
            
        }
        
        
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        
        int n = mat.size();
        ArrayList<String> ans = new ArrayList<String>();
      
        int[][] vis = new int[n][n];
        vis[0][0] = 1;
        find( 0,0,ans,mat,vis,"" );
        return ans;
        
    }
}