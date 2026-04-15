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
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            nodes.add(curr);
            curr = curr.next;
        }
        int l=0,r=nodes.size()-1;
        while(l<r){
            nodes.get(l).next = nodes.get(r);
            l++;
            if(l>=r)
                break;
            nodes.get(r).next = nodes.get(l);
            r--;
        }
        nodes.get(r).next=null;
    }
}
