//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for(int i=0; i<n-1; i++)
                p += Math.max(0,A[i+1]-A[i]);
                
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                int c=0;
                for(int i=0; i<ans.size(); i++)
                    c += A[ans.get(i).get(1)]-A[ans.get(i).get(0)];
                
                if(c==p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        //the basic intution for stock buy ans sell problems are that we can make profit if we can sell it before it goes down
        
        //so for this question to store the pairs we make a list of list
        
        ArrayList<ArrayList<Integer>> stockPairs = new ArrayList<ArrayList<Integer>>();
        
        //now we traverse each stock so that we can take maximum profit
        for(int i = 0; i < n-1; i++) {
            //to store pairs we make a list
            ArrayList <Integer> list = new ArrayList<>();
            
            //check if array is in increasing order if it is in then we surely get profit else loop will end without making any loss 
            
            if(A[i] < A[i+1]){
                //now add a list the index at which we can buy the stack 
                list.add(i);
                
                //skip the days until we get maximum profit on selling the stock
                
                while(i < n-1 && A[i] < A[i+1]) {
                    i++;
                }
                
                //if while skiping we comes at the end of the array then we have to check whether the last index is profitable or not else we skip 
                if(i == n-1 && A[n-2] < A[n-1]){
                    list.add(n-1);
                } 
                //if we are not at the end then surely we encounter a index at which stock  was max of all then we add that stock in our list of pairs
                else {
                    list.add(i);
                }
                
                //then we add pair in our answer list
                stockPairs.add(list);
            }
        }
        
        //if all the array was in decraing order then we return empty list as no pair was added in this else it will return a stack of paurs 
        return stockPairs;
        
        //output will be according to driver class
    }
}
