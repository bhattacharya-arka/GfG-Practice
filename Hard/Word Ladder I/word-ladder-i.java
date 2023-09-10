//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Pair{
    String f;
    int s;
    public Pair(String f,int s){
        this.f=f;
        this.s=s;
    }
        
    
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set=new HashSet<>();
        for(String s1:wordList){
            set.add(s1);
        }
        set.remove(startWord);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        while(!q.isEmpty()){
            String word=q.peek().f;
            int steps=q.peek().s;
            q.poll();
            if(word.equals(targetWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char rep[]=word.toCharArray();
                    rep[i]=ch;
                    String repWord=new String(rep);
                    if(set.contains(repWord)){
                        set.remove(repWord);
                        q.add(new Pair(repWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}