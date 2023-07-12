package leetcode;

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
import java.util.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dHead = new ListNode(-1);
        dHead.next = head;
        ListNode prev = dHead;
        ListNode cur = head;
        while(cur != null){
            while(cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
            }
            if(prev.next == cur){
                prev=prev.next;
            } else{
                prev.next=cur.next;
            }
            cur = cur.next;
        }
        return dHead.next;
    }
}