/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
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

public int maxPathSum(TreeNode root) {

    if (root == null) return 0;

    int[] curMax = { Integer.MIN_VALUE };

    maxPathSum(root, curMax);

    return curMax[0];
}

private int maxPathSum(TreeNode root, int[] curMax) {

    if (root.left == null && root.right == null) {
        curMax[0] = max(curMax[0], root.val);
        return root.val;
    }

    boolean left = root.left != null;
    boolean right = root.right != null;
    
    int leftMax = left ? maxPathSum(root.left, curMax) : 0;
    int rightMax = right ? maxPathSum(root.right, curMax) : 0;
    
    int maxPath = root.val;
    
    if (left && right) {
        curMax[0] = max(curMax[0], leftMax + rightMax + root.val);
    }
    if (left) {
        curMax[0] = max(curMax[0], leftMax + root.val);
        curMax[0] = max(curMax[0], leftMax);
        maxPath = max(maxPath, leftMax + root.val);
    }
    if (right) {
        curMax[0] = max(curMax[0], rightMax + root.val);
        curMax[0] = max(curMax[0], rightMax);
        maxPath = max(maxPath, rightMax + root.val);
    }
    
    curMax[0] = max(curMax[0], root.val);

    return maxPath;
}

private int max(int x, int y) {
    
    return x > y ? x : y;
}
