/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
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

public int sumNumbers(TreeNode root) {

    List<Integer> numbers = new ArrayList<Integer>();

    sumNumbers(root, numbers, 0);

    int result = 0;
    
    for (int num : numbers) {
        result += num;
    }

    return result;
}

private void sumNumbers(TreeNode root, List<Integer> numbers, int currentNum) {
    
    if (root != null) {
        
        currentNum *= 10;
        currentNum += root.val;
        
        if (root.left == null && root.right == null) {
            numbers.add(currentNum);
            return;
        }
        
        if (root.left != null) sumNumbers(root.left, numbers, currentNum);
        if (root.right != null) sumNumbers(root.right, numbers, currentNum);
    }
}
