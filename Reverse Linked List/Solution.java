/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while (head != null) {
            ListNode save = head.next;
            head.next = rev;
            rev = head;
            head = save;
        }

        return rev;
    }
}