//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

 #define m 1000000007
class Solution
{
    public:
  
vector<long long> dp;

long long countWays(int n)
    {
        dp = vector<long long>(n+1);
        dp[0] = 1;
        for(int i = 1; i < n+1; ++i){
            int a, b, c;
            if(i-1 >= 0) dp[i] += dp[i-1] % m;
            if(i-2 >= 0) dp[i] += dp[i-2] % m;
            if(i-3 >= 0) dp[i] += dp[i-3] % m;
        }
        return dp[n] % m;
        
    }
};


//{ Driver Code Starts.
int main()
{
    //taking testcases
	int t;
	cin >> t;
	
	while(t--)
	{
	    //taking number of steps in stair
		int n;
		cin>>n;
		Solution ob;
		//calling function countWays()
		cout << ob.countWays(n) << endl;
	}
    
    return 0;
    
}

// } Driver Code Ends