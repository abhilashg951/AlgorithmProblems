/**
 * Given a linked list, determine if it has a cycle in it.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public boolean hasCycle(ListNode head) {
    
    ListNode curNode = head;
    ListNode runner = head;
    
    while (runner != null && runner.next != null) {
        runner = runner.next.next;
        curNode = curNode.next;
        
        if (curNode == runner) return true;
    }
    
    return false;
}