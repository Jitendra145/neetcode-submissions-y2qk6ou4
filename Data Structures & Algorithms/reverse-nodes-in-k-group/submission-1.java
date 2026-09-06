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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int group = 0;

        while(curr!=null && group <k){
            group++;
            curr = curr.next;
        }
        if(group==k){
            curr = reverseKGroup(curr,k);

            while(group > 0){
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
                group--;
            }
            head = curr;
        }
        return head;
    }
}
