//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
    vector<int> find(int arr[], int n , int x )
    {
        // code here
     //solve this problem by using two pointer approach
     
     int s=0;
     int e=n-1;
     vector<int>v(2,-1);
     while(s<=e){
      if(arr[s]<x && arr[e]>x){
          s++,e--;
      }   
      else if(arr[e]>x){
          e--;
      }
      else if(arr[s]<x){
          s++;
      }
      else{
         v[0]=s;
         v[1]=e;
         return v;
      }
      }
      return v;  
     }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,x;
        cin>>n>>x;
        int arr[n],i;
        for(i=0;i<n;i++)
        cin>>arr[i];
        vector<int> ans;
        Solution ob;
        ans=ob.find(arr,n,x);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
    return 0;
}



// } Driver Code Ends