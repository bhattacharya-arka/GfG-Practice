//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
class Solution{
    static TrieNode root;
    static List<String> ans;
    static void helper(String key, String str){
        if(key.length() == 0) ans.add(str.substring(0, str.length()-1));
        for(int i=1;i <= key.length();i++){
            String s1 = key.substring(0, i);
            String s2 = key.substring(i);
            if(search(root, s1)) helper(s2, str+s1+" ");
        }
    }
    static List<String> wordBreak(int n, List<String> dict, String key){
        root = new TrieNode();
        ans = new ArrayList<>();
        for(String u:dict) insert(root, u);
        helper(key, "");
        return ans;
    }
    static void insert(TrieNode root, String word){
        TrieNode curNode = root;
        for(char u:word.toCharArray()){
            if(curNode.children[u - 'a'] == null){
                curNode.children[u - 'a'] = new TrieNode();
            }
            curNode = curNode.children[u - 'a'];
        }
        curNode.isEndOfWord = true;
    }
    static boolean search(TrieNode root, String word){
        TrieNode curNode = root;
        for(char u:word.toCharArray()){
            if(curNode.children[u - 'a'] == null) return false;
            curNode = curNode.children[u - 'a'];
        }
        return curNode.isEndOfWord;
    }
}