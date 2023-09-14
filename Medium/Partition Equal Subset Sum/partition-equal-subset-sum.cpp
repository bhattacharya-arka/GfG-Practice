//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int equalPartition(int n, int a[])
    {
        int sum = 0;
        for(int i=0;i<n;i++) sum+=a[i];
        if(sum&1) return 0;
        sum/=2;
        vector<bool> dp(sum+1,0);
        dp[0] = 1;
        for(int j=0;j<n;j++)
            for(int i=sum;i>=a[j];i--)
                dp[i] = (dp[i]|dp[i-a[j]]);
        return dp[sum];
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        int arr[N];
        for(int i = 0;i < N;i++)
            cin>>arr[i];
        
        Solution ob;
        if(ob.equalPartition(N, arr))
            cout<<"YES\n";
        else
            cout<<"NO\n";
    }
    return 0;
}
// } Driver Code Ends