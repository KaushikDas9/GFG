//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    
     public static void find( PriorityQueue<Integer> arr,Stack<Integer> s,int n ) { 
        
        if( n==0 ) return ;
        
        arr.add(s.pop());
        find( arr,s,n-1 );
        
        s.push( arr.poll() );
     }
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        PriorityQueue<Integer> p = new PriorityQueue<>();
        find( p,s,s.size() );
        return s;
    }
}