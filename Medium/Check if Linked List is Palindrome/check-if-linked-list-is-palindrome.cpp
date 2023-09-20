//{ Driver Code Starts
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <stack>
using namespace std;
/* Link list Node */
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};




// } Driver Code Ends
/*
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};
*/

class Solution{
  public:
    //Function to check whether the list is palindrome.
    Node* reverse(Node* &head){
        Node* crr=head;
        Node* pre=NULL;
        
        while(crr!=NULL){
            Node* forward=crr->next;
            crr->next=pre;
            pre=crr;
            crr=forward;
        }
        return pre;
    }
    
    bool isPalindrome(Node *head)
    {
        if(head->next==NULL)
        return true;

Node* temp=head;
Node* slow=head;
Node* fast=head;

while(fast!=NULL){
    fast=fast->next;
    if(fast!=NULL){
    fast=fast->next;
    }
    slow=slow->next;
}

  Node* point=reverse(slow);
  
  while(point){
      if(temp->data!=point->data)
      return false;
      temp=temp->next;
      point=point->next;
  }


return true;
    }
};



//{ Driver Code Starts.
/* Driver program to test above function*/
int main()
{
  int T,i,n,l,firstdata;
    cin>>T;
    while(T--)
    {
        
        struct Node *head = NULL,  *tail = NULL;
        cin>>n;
        // taking first data of LL
        cin>>firstdata;
        head = new Node(firstdata);
        tail = head;
        // taking remaining data of LL
        for(i=1;i<n;i++)
        {
            cin>>l;
            tail->next = new Node(l);
            tail = tail->next;
        }
    Solution obj;
   	cout<<obj.isPalindrome(head)<<endl;
    }
    return 0;
}


// } Driver Code Ends