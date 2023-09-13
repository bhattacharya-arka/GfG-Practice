//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        int max=0;
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                s.push(i);
            }
            else{
                s.pop();
            }
            if(s.size()==0){
                s.push(i);
            }
            else{
                max=Math.max(max,i-s.peek());
            }
        }
        return max;
    }
};