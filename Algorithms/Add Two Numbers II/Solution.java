/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> number1 = new Stack<>();
        Stack<Integer> number2 = new Stack<>();
        
        ListNode pointer = l1;
        while (pointer != null) {
            number1.push(pointer.val);
            pointer = pointer.next;
        }
        
        pointer = l2;
        while (pointer != null) {
            number2.push(pointer.val);
            pointer = pointer.next;
        }
        
        int carry = 0;
        ListNode head = null;
        
        while (!number1.isEmpty() && !number2.isEmpty()) {
            int currNumber = number1.pop() + number2.pop() + carry;
            ListNode curr = new ListNode(currNumber % 10, head);
            carry = currNumber / 10;
            head = curr;
        }
        
        Stack<Integer> filled = number1.isEmpty() ? number2 : number1;
        
        while (!filled.isEmpty()) {
            int currNumber = filled.pop() + carry;
            ListNode curr = new ListNode(currNumber % 10, head);
            carry = currNumber / 10;
            head = curr;
        }
        
        while (carry > 0) {
            ListNode curr = new ListNode(carry, head);
            carry /= 10;
            head = curr;
        }
        
        return head;
    }
}