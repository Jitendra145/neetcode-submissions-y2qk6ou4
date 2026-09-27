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
        ListNode res = null;
        for(ListNode list : lists){
            res = mergeTwoLists(res,list);
        }
        return res;
    }

    private ListNode mergeTwoLists(ListNode res, ListNode list){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(res!=null && list!=null){
            if(res.val <=list.val){
                curr.next = res;
                res = res.next;
            }else{
                curr.next = list;
                list = list.next;
            }
            curr = curr.next;
        }

        if(res!=null){
            curr.next = res;
        }else{
            curr.next = list;
        }

        return dummy.next;
    }
}
