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
    public ListNode reverseList(ListNode head) {
        ListNode tmp = new ListNode();

        while(head!=null){
            ListNode node = new ListNode(head.val);
            
            if(tmp.next!=null){                
                node.next = tmp.next;                
            }
            tmp.next = node;
            head = head.next;
        }
        return tmp.next;
    }
}
