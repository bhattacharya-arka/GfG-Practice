//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> stk = new Stack<>();
        long[] res = new long[n];
        stk.push(arr[n-1]);
        res[n-1] = -1;
        
        for(int i=n-2;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=arr[i]) {
                stk.pop();
            } 
            // if stack is not empty take its peek element else -1
            long val = stk.isEmpty()?(-1):stk.peek();
            res[i] = val;
            stk.push(arr[i]);
        }
        return res;
    } 
}