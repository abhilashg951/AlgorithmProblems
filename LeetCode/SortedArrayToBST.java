/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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

public TreeNode sortedArrayToBST(int[] num) {

    if (num == null || num.length < 1) return null;

    return sortedArrayToBST(num, 0, num.length);
}

private TreeNode sortedArrayToBST(int[] num, int start, int end) {

    if (start >= end) return null;

    int middle = (start + end) / 2;

    TreeNode root = new TreeNode(num[middle]);

    root.left = sortedArrayToBST(num, start, middle);
    root.right = sortedArrayToBST(num, middle + 1, end);

    return root;
}