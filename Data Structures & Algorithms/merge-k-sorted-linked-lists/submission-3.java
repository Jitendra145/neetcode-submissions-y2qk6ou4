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
    //bruteforce
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for(ListNode lst : lists){
            while(lst!=null){
                nodes.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(nodes);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int node : nodes){
            curr.next = new ListNode(node);
            curr = curr.next;
        }

        return dummy.next;
    }
}
