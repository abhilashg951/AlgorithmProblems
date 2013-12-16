/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *   3
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public ArrayList<Integer> postorderTraversal(TreeNode root) {
    return postorderTraversal(root, new ArrayList<Integer>());
}

private ArrayList<Integer> postorderTraversal(TreeNode root, ArrayList<Integer> nodes) {
    if (root == null) return nodes;
    if (root.left != null) postorderTraversal(root.left, nodes);
    if (root.right != null) postorderTraversal(root.right, nodes);
    nodes.add(root.val);
    return nodes;
}