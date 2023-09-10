//{ Driver Code Starts
// C++ program to find all distinct palindrome sub-strings
// of a given string
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution{
  public:
    int palindromeSubStrs(string s) {
        unordered_set<string>set;
        vector<vector<bool>>dp(s.size(),vector<bool>(s.size(),false));
       // int count=0;
        int i,j;
        for(int diff=0; diff<s.size();diff++)
        {
            for( i=0,  j=diff; j<s.size(); i++,j++)
            {
                if(diff==0)
                {dp[i][j]=true;}
                
                else if(diff==1)
                {
                    if(s[i]==s[j])
                    dp[i][j]=true;
                    else 
                    dp[i][j]=false;
                }
                
                else
                {
                    if(s[i]==s[j])
                    {
                    dp[i][j]=dp[i+1][j-1];}
                    else
                    dp[i][j]=false;
                }
                if (dp[i][j]==true)
                {
                    string x=s.substr(i,diff+1);
                    if(set.find(x)==set.end())
                    {set.insert(x);}
                }
            }
        }
        return set.size();
    }
};


//{ Driver Code Starts.

// Driver program
int main() {
    int t;
    cin >> t;
    while (t--) {
        string str;
        cin >> str;
        Solution ob;
        cout << ob.palindromeSubStrs(str) << endl;
    }
    return 0;
}

// } Driver Code Ends