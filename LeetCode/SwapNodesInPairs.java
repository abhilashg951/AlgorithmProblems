/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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

public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode newhead = head.next;
    ListNode nextnode = head.next.next;
    
    newhead.next = head;
    head.next = swapPairs(nextnode);
    
    return newhead;
}