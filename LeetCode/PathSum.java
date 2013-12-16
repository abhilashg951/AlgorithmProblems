/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public boolean hasPathSum(TreeNode root, int sum) {

    if (root == null) return false;

    return hasPathSum(root, sum, 0);
}

private boolean hasPathSum(TreeNode root, int sum, int curSum) {

    curSum += root.val;

    if (root.left == null && root.right == null) return sum == curSum;
    
    boolean leftPath = root.left == null ? false : hasPathSum(root.left, sum, curSum);
    boolean rightPath = root.right == null ? false : hasPathSum(root.right, sum, curSum);
    
    return leftPath || rightPath;
}
