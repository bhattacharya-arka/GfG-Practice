//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n) {
        if (n == 0) {
            return 0;
        }
        
        String binary = intToBinary(n);
        
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                return binary.length() - i;
            }
        }
        
        return 0;
    }
    
    public static String intToBinary(int n) {
        return Integer.toBinaryString(n);
    }

    public static int countdigits(int n){
        int count=0;
        while(n!=0){
            count++;
            n=n/10;
        }
        return count;
    }
} 