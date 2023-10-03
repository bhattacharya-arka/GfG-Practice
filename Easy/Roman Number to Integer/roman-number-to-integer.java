//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        int sum = 0,n=str.length();
        HashMap<Character,Integer> h = new HashMap<Character,Integer>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        if(n==1){
           return h.get(str.charAt(0));
        }
        for(int i = 0;i<n-1;i++){
            if(h.get(str.charAt(i))<h.get(str.charAt(i+1))){
                sum-=h.get(str.charAt(i));
            }else{
                sum+=h.get(str.charAt(i));
            }
        }
        sum+=h.get(str.charAt(n-1));
        return sum;
    }
}