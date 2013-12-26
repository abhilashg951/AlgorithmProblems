/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
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

public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    int numAtLevel = 1, thisNumAtLevel;
    
    while( ! queue.isEmpty()) {
        
        ArrayList<Integer> thisLevel = new ArrayList<Integer>();
        
        thisNumAtLevel = numAtLevel;
        numAtLevel = 0;
        
        // Take from queue for all nodes at this level
        for (int i = 0; i < thisNumAtLevel; i++) {
            TreeNode curnode = queue.poll();
            thisLevel.add(curnode.val);
            
            if (curnode.left != null) {
                queue.offer(curnode.left);
                numAtLevel++;
            }
            if (curnode.right != null) {
                queue.offer(curnode.right);
                numAtLevel++;
            }
        }
        result.add(thisLevel);
    }
    return result;
}