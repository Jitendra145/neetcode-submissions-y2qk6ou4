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
    //gfg naive, merge list one by one
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode res = null;
        for(ListNode node : lists){
            res = mergeTwoLists(res,node);
        }
        return res;
    }

    private ListNode mergeTwoLists(ListNode res, ListNode node){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(res != null && node != null){
            if(res.val <= node.val){
                curr.next = res;
                res = res.next;
            }else{
                curr.next = node;
                node = node.next;
            }
            curr = curr.next;
        }

        if(res != null){
            curr.next = res;
        }else{
            curr.next = node;
        }

        return dummy.next;
    }
}
