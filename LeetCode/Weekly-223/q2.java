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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode ans = head;
        int start = k-1;
        ListNode temp = head;
        int sz = 0;
        while(temp != null)
        {
            temp=temp.next;
            sz++;
        }
        ListNode begin = head;
        while(start-- > 0)
        {
            begin = begin.next;
        }
        int val1 = begin.val ;
        int end = sz - k ;
        ListNode ending = head;
        while(end-- > 0)
        {
            ending=ending.next;
        }
        int val2 = ending.val;
        begin.val = val2;
        ending.val = val1;
        return ans;
    }
}
