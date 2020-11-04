/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> all = new HashSet<>();

        while (headA != null) {
            all.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (all.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}