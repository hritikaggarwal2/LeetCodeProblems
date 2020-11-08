/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private void addToList(TreeNode root, int height, List<List<Integer>> zigzagList) {
        if (root == null) {
            return;
        }

        if (zigzagList.size() < height + 1) {
            zigzagList.add(new LinkedList<>());
        }

        if (height % 2 == 0) {
            zigzagList.get(height).add(root.val);
        } else {
            zigzagList.get(height).add(0, root.val);
        }

        addToList(root.left, height + 1, zigzagList);
        addToList(root.right, height + 1, zigzagList);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        addToList(root, 0, zigzagList);

        return zigzagList;
    }
}