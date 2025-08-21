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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null) return null;
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        ListNode c=head;
        for(int i=1;i<len/2;i++) c=c.next;
        c.next=c.next.next;
        return head;
    }
}