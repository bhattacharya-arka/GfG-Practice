//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution{
    public:
    // arr[] : int input array of integers
    // k : the quadruple sum required
     vector<vector<int> > fourSum(vector<int> &arr, int K) {
        // Your code goes here
        sort(arr.begin(),arr.end());
        set<vector<int>>s;
        int n=arr.size();
        for(int i=0;i<n-3;i++)
        {
            for(int j=i+1;j<n-2;j++)
            {
               int newtarget=K-(arr[i]+arr[j]);
               int start=j+1;
               int end=n-1;
               while(start<end)
               {
                    //cout<<newtarget<<" "<< arr[start]+arr[end]<<endl;
                    if(arr[start]+arr[end]<newtarget) start++;
                    else if(arr[start]+arr[end]>newtarget) end--;
                    else
                    {
                        s.insert({arr[i],arr[j],arr[start],arr[end]});
                        start++;end--;
                    }
                    
                }
            }
            
        }
        vector<vector<int>>ans(s.begin(),s.end());
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, i;
        cin >> n >> k;
        vector<int> a(n);
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        vector<vector<int> > ans = ob.fourSum(a, k);
        for (auto &v : ans) {
            for (int &u : v) {
                cout << u << " ";
            }
            cout << "$";
        }
        if (ans.empty()) {
            cout << -1;
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends