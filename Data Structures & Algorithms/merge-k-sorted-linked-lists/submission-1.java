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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        return mergeKListsRec(0,lists.length-1,lists);
    }

    public ListNode mergeKListsRec(int i, int j, ListNode[] lists){
        if(i==j)
            return lists[i];
        
        int mid = i + (j-i)/2;

        ListNode head1 = mergeKListsRec(i,mid,lists);
        ListNode head2 = mergeKListsRec(mid+1,j,lists);

        return mergeTwoLists(head1,head2);
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                curr.next = head1;
                head1 = head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if(head1 != null){
            curr.next = head1;
        }else{
            curr.next = head2;
        }

        return dummy.next;
    }
}
