/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private int found = 0;
    private TreeNode ans = null;

    private boolean getAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || ans != null) {
            return false;
        }

        boolean isCurr = false;
        if (root == p || root == q) {
            isCurr = true;
            found++;

            if (found == 2) {
                return true;
            }
        }

        boolean resLeft = getAncestor(root.left, p, q);

        if (resLeft && isCurr) {
            ans = root;
            return false;
        }

        boolean resRight = getAncestor(root.right, p, q);

        if (resRight && resLeft || resRight && isCurr) {
            ans = root;
            return false;
        }

        return resLeft || resRight || isCurr;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        getAncestor(root, p, q);

        return ans;
    }
}