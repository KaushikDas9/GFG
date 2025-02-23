//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static int rank(char ch){
        if(ch == '+' || ch == '-') return 1;
        if(ch == '/' || ch == '*') return 2;
        if(ch == '^') return 3;
        
        return -1;
    }
    public static boolean checkIsOperator(char ch){
        if(ch == '+' || ch == '-' ||
        ch == '*' || ch == '/' || ch == '^' ||
        ch == '(' || ch == ')') return true;
        
        return false;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stk = new Stack();
        
        int len = s.length();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
                // System.out.println(ans+"\t"+ch);
            if(!checkIsOperator(ch)){     // if ch is not an operator
                ans.append(ch);
            }
            else{               // if ch is an operator
                if(stk.isEmpty() || ch == '(') stk.push(ch);    // if stk is empty or a open bracket occurs
                else if(ch == ')'){

                    while(!stk.isEmpty() && stk.peek() != '('){
                        ans.append(stk.pop());
                    }
                    stk.pop();
                }
                else{       // if stack is not empty
                    while(!stk.isEmpty() && rank(stk.peek()) >= rank(ch)){  // check stk peek element's precedence should be less than current ch's precedence
                        ans.append(stk.pop());
                    }
                    
                    stk.push(ch);
                }
            }
        }
        while(!stk.isEmpty()) ans.append(stk.pop());
        
        return ans.toString();
    }
}