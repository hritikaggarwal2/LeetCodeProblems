/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private void connectHelper(Node root, Node side) {
        if (root == null) {
            return;
        }

        root.next = side;

        connectHelper(root.left, root.right);
        // connectHelper(root.right, side.left);
        if (side == null) {
            connectHelper(root.right, side);
        } else if (side.left == null) {
            connectHelper(root.right, side.right);
        } else {
            connectHelper(root.right, side.left);
        }

        return;
    }

    public Node connect(Node root) {
        connectHelper(root, null);
        return root;
    }
}