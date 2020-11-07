/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private void fillLevelOrderList(TreeNode root, List<List<Integer>> levels, int height) {
        if (root == null) {
            return;
        }

        if (levels.size() < height) {
            levels.add(new LinkedList<>());
        }

        levels.get(height - 1).add(root.val);
        fillLevelOrderList(root.left, levels, height + 1);
        fillLevelOrderList(root.right, levels, height + 1);

        return;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        fillLevelOrderList(root, levels, 1);
        return levels;
    }
}