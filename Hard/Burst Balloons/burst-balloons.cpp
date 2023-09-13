//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
public:
    int maxCoins(int N, vector<int> &arr) {
        arr.push_back(1);
        arr.insert(arr.begin(),1);
        vector<vector<int>> dp(N+2,vector<int>(N+2,0));
        
        for(int i=N;i>0;i--)
        {   int cost=0;
            for(int j=1;j<=N;j++)
            {
                for(int k=i;k<=j;k++)
                {   if(i>j) continue;
                    else
                    {
                        
                        int c=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                        cost=max(cost,c);
                    }
                }
                dp[i][j]=cost;
            }
        }
        return dp[1][N];
        // code here
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        
        vector<int> arr(N);
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution obj;
        cout << obj.maxCoins(N, arr) << endl;
    }
    return 0;
}
// } Driver Code Ends