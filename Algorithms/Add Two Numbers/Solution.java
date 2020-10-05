/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode a = l1;
        ListNode b = l2;

        int carry = 0;
        ListNode curr = sum;
        while (a != null && b != null) {
            int total = a.val + b.val + carry;
            carry = total / 10;
            curr.next = new ListNode(total % 10);
            curr = curr.next;
            a = a.next;
            b = b.next;
        }

        ListNode leftover = a != null ? a : b;

        while (leftover != null) {
            int total = leftover.val + carry;
            carry = total / 10;
            curr.next = new ListNode(total % 10);
            curr = curr.next;
            leftover = leftover.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry % 10);
        }

        return sum.next;
    }
}