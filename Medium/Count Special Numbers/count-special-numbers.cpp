//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int countSpecialNumbers(int n, vector<int> arr) {
        // Code here
      int count=0;
    map<int,int> um;
    for(int i=0;i<n;i++){
        um[arr[i]]++;
        
    }
    for(auto it:um){
        
        if(it.second>1){
            count+=it.second;
        }
        else{
            for(auto pt:um){
                if(pt.first>=it.first){
                    break;
                }
                if(it.first>pt.first && it.first%pt.first==0 ){
                    count++;
                    break;
                }
            }
        }
    }
    return count;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }

        Solution ob;
        cout << ob.countSpecialNumbers(N, arr) << endl;
    }
    return 0;
}
// } Driver Code Ends