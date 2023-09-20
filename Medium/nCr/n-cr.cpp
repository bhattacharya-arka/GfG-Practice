//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
public:
    const int mod = 1e9 + 7;
    
    long long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        long long result = 1;
        for (int i = 2; i <= n; ++i) {
            result = (result * i) % mod;
        }
        return result;
    }
    
    int nCr(int n, int r) {
        if (r > n) {
            return 0;  // Invalid input, as r should not be greater than n.
        }
        long long numerator = factorial(n);
        long long denominator = (factorial(r) * factorial(n - r)) % mod;
        // Calculate the modular multiplicative inverse of the denominator to get the result.
        long long inverse_denominator = mod_inverse(denominator);
        return (numerator * inverse_denominator) % mod;
    }

    // Function to calculate the modular multiplicative inverse.
    long long mod_inverse(long long num) {
        long long result = 1;
        long long exp = mod - 2;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * num) % mod;
            }
            num = (num * num) % mod;
            exp /= 2;
        }
        return result;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, r;
        cin>>n>>r;
        
        Solution ob;
        cout<<ob.nCr(n, r)<<endl;
    }
    return 0;
}
// } Driver Code Ends