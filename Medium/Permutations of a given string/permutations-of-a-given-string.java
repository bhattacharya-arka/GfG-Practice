//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    
    public static void permutation(char ch[],int l,int r,HashSet<String> k)
    {
        if(l==r)
        {
            k.add(new String(ch));
            return;
        }
        for(int i=l;i<=r;i++)
        {
            swap(ch,i,l);
            permutation(ch,l+1,r,k);
            swap(ch,i,l);
        }
    }
    
    public static void swap(char ch[],int i,int j)
    {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    
    
    public List<String> find_permutation(String s) {
        // Code here
        char ch[]=s.toCharArray();
        
        HashSet<String> l=new HashSet<>();
        permutation(ch,0,ch.length-1,l); 
        List<String> w=new ArrayList(l);
        Collections.sort(w);
        return w;
         
    }
}