//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends

class Solution{
public:
    vector<int> findTwoElement(vector<int> arr, int n) {
        for(int i=0;i<n;i++){
            int element=arr[i];
            int chair=element-1;
            if(arr[chair]!=element){
                swap(arr[chair],arr[i]);
                i--;
            }
        }
        vector<int>ans(2,0);
      for(int i=0; i<n; i++){
    if(i + 1 != arr[i]){
        ans[0] = arr[i]; // Repeated element
        ans[1] = i + 1;  // Missing element
        break;
    }
}
return ans;
}
};  


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a, n);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}
// } Driver Code Ends