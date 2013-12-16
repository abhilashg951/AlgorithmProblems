/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

 public RandomListNode copyRandomList(RandomListNode head) {

    if (head == null) return null;
    
    RandomListNode newHead = new RandomListNode(head.label);
    
    RandomListNode curNode = head;
    RandomListNode newNode = newHead;
    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    map.put(curNode, newNode);

    while (curNode.next != null) {
        newNode.next = new RandomListNode(curNode.next.label);
        newNode = newNode.next;
        curNode = curNode.next;
        map.put(curNode, newNode);
    }
    
    curNode = head;
    newNode = newHead;
    newNode.random = map.get(curNode.random);
    
    while (curNode.next != null) {
        newNode = newNode.next;
        curNode = curNode.next;
        newNode.random = map.get(curNode.random);
    }
    
    return newHead;
}
