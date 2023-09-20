//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends

class Solution
{
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return arr[0];
        }
        
        int[] dp = new int[n];
        
        // Initialize the first two elements of the dp array.
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        // Calculate the maximum money that can be obtained for each house.
        for (int i = 2; i < n; i++) {
            // The thief can either skip the current house or loot it.
            // If he loots it, he adds the current house's value to the value obtained
            // two houses before (to ensure no consecutive houses are looted).
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        
        // The maximum money that can be obtained is stored in dp[n-1].
        return dp[n - 1];
    }
}