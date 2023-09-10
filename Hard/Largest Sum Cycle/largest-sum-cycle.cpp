//{ Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution
{
  public:
  bool dfs(vector<int>adj[],bool mark[],bool pathvis[],int i,long long int &ans)
  {
      mark[i]=true;
      pathvis[i]=true;
      for(auto x:adj[i])
      {
          if(!mark[x])
          {
              if(dfs(adj,mark,pathvis,x,ans)==false)
              {  
                  ans+=x;
                  return false;
              }
          }
          else if(pathvis[x]==true)
          {
           
              return false;
          }
      }
      pathvis[i]=false;
      return true;
  }
  long long largestSumCycle(int n, vector<int> edge)
  {
    // code here
    vector<int>adj[n];
    for(int i=0;i<n;i++)
    {
       if(edge[i]!=-1) adj[edge[i]].push_back(i);
    }
    long long int ans=0;
    bool mark[n]={false};
    bool pathvis[n]={false};
   // int ans=0;
   long long int max_ans=0;
    for( int i=0;i<n;i++)
    {
        if(!mark[i])
        {   ans=0;
            bool flag = dfs(adj,mark,pathvis,i,ans);
            if(flag==false) ans+=i;
            max_ans=max(max_ans,ans);
        }
       
    }
    if(max_ans==0) return -1;
    return max_ans;
  }
};

//{ Driver Code Starts.
signed main(){
   int tc;
   cin >> tc;
   while(tc--){
      int N;
      cin >> N;
      vector<int> Edge(N);
      for(int i=0;i<N;i++){
        cin>>Edge[i];
      }
      Solution obj;
      long long ans=obj.largestSumCycle(N, Edge);
      cout<<ans<<endl;
   }
   return 0;
}
// } Driver Code Ends