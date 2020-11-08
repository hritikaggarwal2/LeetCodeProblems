/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int processed = 0;

    private TreeNode makeTree(int[] preorder, int[] inorder, int startIn, int endIn) {
        if (processed >= preorder.length || startIn > endIn) {
            return null;
        }

        TreeNode parent = new TreeNode(preorder[processed]);
        if (startIn == endIn) {
            processed++;
            return parent;
        }

        int inIndex = startIn;

        while (inorder[inIndex] != preorder[processed]) {
            inIndex++;
        }

        processed++;

        parent.left = makeTree(preorder, inorder, startIn, inIndex - 1);
        parent.right = makeTree(preorder, inorder, inIndex + 1, endIn);

        return parent;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return makeTree(preorder, inorder, 0, inorder.length);
    }
}