//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
  public:
    string isSumOfConsecutive(int N) {
        // code here
       if((N&(N-1))==0)
       return "No";
       else
       return "Yes";
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        
        cin>>N;

        Solution ob;
        cout << ob.isSumOfConsecutive(N) << endl;
    }
    return 0;
}
// } Driver Code Ends