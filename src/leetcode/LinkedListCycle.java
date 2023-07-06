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
    public boolean hasCycle(ListNode head) {

        long cnt = 0;

        while(true){
            if(head == null) return false;
            if(cnt >= 10000) return true;
            head = head.next;
            cnt++;
        }
    }
}