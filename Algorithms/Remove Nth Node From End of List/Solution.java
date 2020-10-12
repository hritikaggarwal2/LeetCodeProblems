/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currNode = head;
        ListNode skipperNode = currNode;

        int counter = n;
        while (skipperNode != null && counter-- > 0) {
            skipperNode = skipperNode.next;
        }

        if (skipperNode == null) {
            return head.next;
        }

        while (skipperNode != null) {
            if (skipperNode.next == null) {
                currNode.next = currNode.next.next;
                break;
            } else {
                skipperNode = skipperNode.next;
                currNode = currNode.next;
            }
        }

        return head;
    }
}