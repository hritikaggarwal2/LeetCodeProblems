/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    private class Element {
        ListNode l;
        int val;

        Element(ListNode l, int val) {
            this.l = l;
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode l : lists) {
            if (l != null) {
                pq.add(new Element(l, l.val));
            }
        }

        while (!pq.isEmpty()) {
            ListNode get = pq.remove().l;
            curr.next = get;
            get = get.next;
            curr = curr.next;
            curr.next = null;

            if (get != null) {
                pq.add(new Element(get, get.val));
            }
        }

        return head.next;
    }
}