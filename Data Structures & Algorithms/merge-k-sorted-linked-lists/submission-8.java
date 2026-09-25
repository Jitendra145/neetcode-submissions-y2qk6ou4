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
    //O(n * log k), O(k) n is the total sum of nodes from all lists.
    //There are at most k elements at any instant
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list : lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = node;

            node = node.next;
            if(node!=null){
                minHeap.offer(node);
            }
        }
        return dummy.next;
    }
}
