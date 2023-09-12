//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends
class Solution{
public:
    int isHappy(int n){
        int x=7;
        while(x--)
        {
            int sum=0;
            while(n>0)
            {
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            n=sum;
        }
        return (n==1);
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.isHappy(N) << endl;
    }
    return 0; 
}
// } Driver Code Ends