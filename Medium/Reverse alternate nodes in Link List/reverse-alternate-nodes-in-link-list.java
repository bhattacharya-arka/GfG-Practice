//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution{
    public static void rearrange(Node head){
        // add your code here
        ArrayList<Integer> l2 = new ArrayList<>();
        Node temp = head;
        while(temp != null && temp.next != null){
            l2.add(temp.next.data);
            temp = temp.next.next;
        }
        Node p = head;
        while(p != null && p.next != null){
            p.next = p.next.next;
            p = p.next;
        }
        Collections.reverse(l2);
        Node mergall = new Node(-1);
        Node t = mergall;
        for(Integer k : l2){
            Node newnode = new Node(k);
            t.next = newnode;
            t = t.next;
        }
        Node r = head;
        while(r.next != null){
            r = r.next;
        }
        r.next =  mergall.next;
    }
}