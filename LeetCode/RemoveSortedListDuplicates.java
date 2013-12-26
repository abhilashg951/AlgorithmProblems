/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public ListNode deleteDuplicates(ListNode head) {
        
    if (head == null || head.next == null) return head;
    
    ListNode curnode = head;
    
    while (curnode.next != null) {
        curnode.next = getNextDifferent(curnode, curnode.next);
        if (curnode.next == null) break;
        curnode = curnode.next;
    }
    
    return head;
}

private ListNode getNextDifferent(ListNode node, ListNode next) {
    while (next != null && next.val == node.val) {
        next = next.next;
    }
    return next;
}
