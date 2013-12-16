/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (hasLeftChild(root) && hasRightChild(root)) return min(minDepth(root.left), minDepth(root.right)) + 1;
    if (hasLeftChild(root)) return minDepth(root.left) + 1;
    if (hasRightChild(root)) return minDepth(root.right) + 1;
    return 1;
}

private int min(int x, int y) {
    return x < y ? x : y;
}

private boolean hasLeftChild(TreeNode node) {
    return node.left != null;
}

private boolean hasRightChild(TreeNode node) {
    return node.right != null;
}
