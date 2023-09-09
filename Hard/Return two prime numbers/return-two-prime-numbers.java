//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> primeDivision(int N){
        // code here
         ArrayList<Integer> list = new ArrayList<>();
         ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        
        for(int c = 0 ; c < list.size()  ; c++)
        {
            int s = N - list.get(c);
            if(list.contains(s))
            {
                list1.add(list.get(c));
                list1.add(s);
            }
           
        }
         return list1;
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

