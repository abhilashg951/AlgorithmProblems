/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
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

public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> nodes = new ArrayList<Integer>();
    if (root != null) inorderTraversal(root, nodes);
    return nodes;
}

private void inorderTraversal(TreeNode root, ArrayList<Integer> nodes) {
    if (root == null) return;
    inorderTraversal(root.left, nodes);
    nodes.add(root.val);
    inorderTraversal(root.right, nodes);
}
