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
    //using min heap optimized solution
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node!=null)
                minHeap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            node = node.next;
            if(node!=null){
                minHeap.offer(node);
            }
        }
        return dummy.next;
    }
}
