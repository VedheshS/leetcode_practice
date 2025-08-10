/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right) return head;
        int n=1;
        ListNode cur=head;
        ListNode tail=null;
        if(left==1){
            tail=cur;
            while(cur!=null){
                if(n==right) {
                    head=cur;
                    break;
                }
                n++;
                cur=cur.next;
            }
            cur=tail;
            n=1;
        }
        else{
            while(cur!=null){
                if(n+1==left){
                    tail=cur.next;
                    n+=1;
                    break;
                }
                cur=cur.next;
                n++;
            }
        }
        ListNode start=cur;
        if(left!=1) cur=cur.next;
        ListNode pre=null;
        while(cur!=null){
            if(n>right){
                break;
            }
            ListNode t=cur.next;
            cur.next=pre;
            pre=cur;
            cur=t;
            n++;
        }
        tail.next=cur;
        if(left==1) head=pre;
        else start.next=pre;
        return head;
    }
}