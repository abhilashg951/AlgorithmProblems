/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
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

public ListNode detectCycle(ListNode head) {
    
    ListNode curNode = head;
    ListNode runner = head;
    
    while (runner != null && runner.next != null) {
        
        runner = runner.next.next;
        curNode = curNode.next;
        if (curNode == runner) break;
    }
    
    if (runner == null || runner.next == null) return null;
    
    runner = head;
    
    while (runner != curNode) {
        runner = runner.next;
        curNode = curNode.next;
    }
    
    return runner;
}