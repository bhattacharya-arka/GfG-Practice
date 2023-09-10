//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // using the divide and conquer (merge sort) recursion
        return mergeSort(arr, 0, N - 1);
    }

    static long mergeSort(long[] arr, long s, long e)
    {
        long count = 0;

        if (s < e)
        {
            long mid = s + (e - s) / 2;

            count += mergeSort(arr, s, mid);
            count += mergeSort(arr, mid + 1, e);

            count += merge(arr, s, mid, e);
        }

        return count;
    }

    static long merge(long[] arr, long s, long mid, long e)
    {
        long[] localArray = new long[(int)(e - s + 1)];
        long count = 0;

        long lp = s;
        long rp = mid + 1;
        long idx = 0;

        while (lp <= mid && rp <= e)
        {
            if (arr[(int)lp] <= arr[(int)rp])
            {
                localArray[(int)idx++] = arr[(int)lp++];
            }
            else
            {
                localArray[(int)idx++] = arr[(int)rp++];
                count += (mid - lp + 1); // Count inversions when arr[lp] > arr[rp]
            }
        }

        while (lp <= mid)
        {
            localArray[(int)idx++] = arr[(int)lp++];
        }

        while (rp <= e)
        {
            localArray[(int)idx++] = arr[(int)rp++];
        }

        for (int i = 0; i < localArray.length; i++)
        {
            arr[(int)(s + i)] = localArray[i];
        }

        return count;
    }
}