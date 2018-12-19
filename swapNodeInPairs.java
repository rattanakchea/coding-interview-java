/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class Solution {
   public ListNode swapPairs(ListNode head) {
     ListNode fake = new ListNode(0);
     ListNode previous = fake;
     fake.next = head;


     ListNode temp = head;

     while(temp != null && temp.next != null){
       ListNode second = temp.next;
       ListNode next = temp.next.next;

       previous.next = second;
       second.next = temp;
       temp.next = next;

       previous = temp;
       temp = next;
     }

     return fake.next;
   }
 }
