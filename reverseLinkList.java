// Author: Chamnab Lim, Rattanak Chea
// Reverse a singly linked list.
// 1->2->3->4->5 becomes 5->4->3->2->1
// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // recursively solution
 class Solution {
    public ListNode reverseList(ListNode head) {
        // if head is null, there is nothing to reverse
        if (head == null) return head;

        // newHead will retreive the first node after reverse
        ListNode newHead = reverse(head);

        // head will become last node, so we want its' next to point to null
        head.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode head){
        // base case: last node in the list
        if (head.next == null) return head;
        ListNode lastNode = reverse(head.next);
        // start reverse node
        head.next.next = head;
        // return last node all the way to called public method
        return lastNode;
    }

    // reverse linkedlist iterative
    public ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
