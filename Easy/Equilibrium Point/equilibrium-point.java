//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {   

    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if(n == 1){
            return 1;
        }
        
        long before_sum[] = new long[n];
        long after_sum[] = new long[n];
        
        // calculate the before sum
        long bsum = 0;
        for(int i = 0;i<n;i++){
            bsum += arr[i];
            
            before_sum[i] = bsum;
        }
        
        // calculate the after sum
        long asum = 0;
        for(int i = n-1;i>=0;i--){
            asum += arr[i];
            after_sum[i] = asum;
        }
        
        // find equilibrium point
        for(int i = 1;i<n-1;i++){
            long b_sum = before_sum[i-1];
            long a_sum = after_sum[i+1];
            
            if(b_sum == a_sum){
                return i+1;
            }
        }
        
        return -1;
        
    }
}