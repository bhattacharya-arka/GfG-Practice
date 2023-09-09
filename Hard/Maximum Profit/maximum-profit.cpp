//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int maxProfit(int k, int N, int prices[]) {
         int n=N;     
          vector<int>after(2*k+1,0);
           for(int i=n-1;i>=0;i--){
             for(int transno=2*k-1;transno>=0;transno--)
             {
                 if(transno%2==0)
             after[transno]=max(-prices[i]+after[transno+1],after[transno]);
              else
            after[transno]=max(prices[i]+after[transno+1],after[transno]);   
             }
           }
           return after[0];

    }


};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin >> K;
        cin >> N;
        int A[N];
        for (int i = 0; i < N; i++) cin >> A[i];

        Solution ob;
        cout << ob.maxProfit(K, N, A) << endl;
    }
    return 0;
}
// } Driver Code Ends