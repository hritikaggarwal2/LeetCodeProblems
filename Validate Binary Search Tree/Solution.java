/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    private boolean isValidHelper(TreeNode root, long lowest, long highest) {
        if (root == null) {
            return true;
        }

        if (root.val > lowest && root.val < highest) {
            return true && isValidHelper(root.left, lowest, root.val) && isValidHelper(root.right, root.val, highest);
        }

        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}