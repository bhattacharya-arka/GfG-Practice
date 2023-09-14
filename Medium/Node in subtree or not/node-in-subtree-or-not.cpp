//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
       int timer=1;
        
        void dfs(int src, vector<vector<int>> &g, vector<int>&vis, vector<int>&in, vector<int>&out){
            in[src]=timer++;
            vis[src]=1;
            
            for(auto &x: g[src]){
                if(vis[x]==0){
                    dfs(x,g,vis,in,out);
                }
            }
            
            out[src]=timer++;
        }
    
        bool inSubtree(int a, int b, vector<int>&in, vector<int>&out){
            if(in[b]<=in[a] && out[b]>=out[a])return true;
            return false;
        }
        
        vector<string> isInSubtree(vector<vector<int>> &g,int n,int q,vector<vector<int>> queries)
        {
            // code here
            
           
            
            vector<int>vis(n+1),in(n+1),out(n+1);
            dfs(1,g,vis,in,out);
            
            vector<string>ans;
            
            for(auto &x: queries){
                int u = x[0];
                int v = x[1];
                
                if(inSubtree(u,v,in,out))ans.push_back("YES");
                else ans.push_back("NO");
            }
            
            return ans;
            
        }

};

//{ Driver Code Starts.

int main()
{
    
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        vector<vector<int>> g(n+1);
        for(int i=1;i<n;i++)
        {
            int a,b;
            cin>>a>>b;
            g[a].push_back(b);
            g[b].push_back(a);
        }
        int q;
        cin>>q;
        vector <vector<int>> queries(q,vector<int> (2));
        for(auto &j:queries)
            cin>>j[0]>>j[1];
        
        Solution s;
        vector<string> ans=s.isInSubtree(g,n,q,queries);
        for(auto j:ans)
            cout<<j<<endl;
    }
    return 0;
}
// } Driver Code Ends