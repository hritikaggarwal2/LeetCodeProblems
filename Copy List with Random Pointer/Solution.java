/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> copied;

    public Node copyRandomList(Node head) {
        copied = new HashMap<>();
        return copyRandomListHelper(head);
    }

    private Node copyRandomListHelper(Node node) {
        if (node == null) {
            return null;
        } else if (copied.containsKey(node)) {
            return copied.get(node);
        }

        Node copy = new Node(node.val);
        copied.put(node, copy);

        copy.next = copyRandomListHelper(node.next);
        copy.random = copyRandomListHelper(node.random);

        return copy;
    }
}