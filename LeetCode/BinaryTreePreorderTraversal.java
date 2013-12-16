/** 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
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

public ArrayList<Integer> preorderTraversal(TreeNode root) {
    return preorderTraversal(root, new ArrayList<Integer>());
}

private ArrayList<Integer> preorderTraversal(TreeNode root, ArrayList<Integer> nodes) {
    if (root == null) return nodes;
    nodes.add(root.val);
    if (root.left != null) preorderTraversal(root.left, nodes);
    if (root.right != null) preorderTraversal(root.right, nodes);
    return nodes;
}
