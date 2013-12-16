/** 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    if (root == null) return result;
    
    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();

    s1.push(root);
    
    while( ! s1.isEmpty() || ! s2.isEmpty()) {
        
        ArrayList<Integer> thisLevel = new ArrayList<Integer>();
        boolean done = traverseLevel(s1, s2, thisLevel, true);
        result.add(thisLevel);
       
        if (done) break;
    
        thisLevel = new ArrayList<Integer>();
        traverseLevel(s2, s1, thisLevel, false);
        result.add(thisLevel);
    }
    
    return result;
}

private boolean traverseLevel(Stack<TreeNode> origStack, Stack<TreeNode> otherStack, 
    ArrayList<Integer> levelResult, boolean zig) {
    
    while( ! origStack.isEmpty()) {
        
        TreeNode curnode = origStack.pop();
        levelResult.add(curnode.val);
        
        if (zig) {
            if (curnode.left != null) {
                otherStack.push(curnode.left);
            }
            if (curnode.right != null) {
                otherStack.push(curnode.right);
            }
        } 
        else {
            if (curnode.right != null) {
                otherStack.push(curnode.right);
            }
            if (curnode.left != null) {
                otherStack.push(curnode.left);
            }
        }
    }
    
    return otherStack.isEmpty();
} 
