package leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow, fast;

        if(head == null || head.next == null) return null;

        slow = head;
        fast = head.next;

        while(true){

            if(slow == fast) break;

            if(slow.next == null || fast.next == null || fast.next.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp;
        temp = head;
        slow = slow.next;

        while(true){
            if(temp == slow) return slow;
            slow = slow.next;
            temp = temp.next;
        }

    }
}
Console
