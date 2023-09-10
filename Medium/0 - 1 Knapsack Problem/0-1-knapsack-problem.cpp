//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
   vector<vector<int>> memo; 
    int ksnap(int index, int W, int wt[], int val[])
    {
        if (index == 0)
        {
            return 0;
        }

        int &ans = memo[index][W];

        if (ans != -1)
        {
            return ans;
        }
        ans = 0;

        if (wt[index-1] <= W) 
        {
            ans = max(val[index - 1] + ksnap(index - 1, W - wt[index - 1], wt, val),ksnap(index - 1, W, wt, val));
        }
    else
    {
        ans = ksnap(index - 1, W, wt, val);
    }
        return ans;
    }
    
    int knapSack(int W, int wt[], int val[], int n)
    {
        memo.resize(n + 1, vector<int>(W + 1, -1)); 

        return ksnap(n, W, wt, val); 
    }
};


//{ Driver Code Starts.

int main()
 {
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //reading number of elements and weight
        int n, w;
        cin>>n>>w;
        
        int val[n];
        int wt[n];
        
        //inserting the values
        for(int i=0;i<n;i++)
            cin>>val[i];
        
        //inserting the weights
        for(int i=0;i<n;i++)
            cin>>wt[i];
        Solution ob;
        //calling method knapSack()
        cout<<ob.knapSack(w, wt, val, n)<<endl;
        
    }
	return 0;
}
// } Driver Code Ends