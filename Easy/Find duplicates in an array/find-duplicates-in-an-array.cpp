//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
  public:
    vector<int> duplicates(int arr[], int n) {
        // code here
        vector<int> ans;
        sort(arr,arr+n);
        int check =-1;
        for(int i = 1 ; i < n ; i++ )
        {
            if(arr[i] == check) continue;
            if(arr[i] == arr[i-1])
            {
                check = arr[i];
                ans.push_back(check);
            }
        }
        if(ans.empty()) ans.push_back(-1);
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) cin >> a[i];
        Solution obj;
        vector<int> ans = obj.duplicates(a, n);
        for (int i : ans) cout << i << ' ';
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends