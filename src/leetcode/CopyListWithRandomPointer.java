package leetcode;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.*;

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node cur = head;
        Node ans = new Node(head.val);
        Node cur2 = ans;
        Map<Node, Node> hm = new HashMap<>();


        while(cur != null){
            cur2.val = cur.val;
            hm.put(cur, cur2);

            if(cur.next == null){
                cur2.next = null;
            }else{
                if(hm.containsKey(cur.next)){
                    cur2.next = hm.get(cur.next);
                }else{
                    cur2.next = new Node(cur.next.val);
                    hm.put(cur.next, cur2.next);
                }
            }

            if(cur.random == null){
                cur2.random = null;
            }else{
                if(hm.containsKey(cur.random)){
                    cur2.random = hm.get(cur.random);
                }else{
                    cur2.random = new Node(cur.random.val);
                    hm.put(cur.random, cur2.random);
                }
            }

            cur = cur.next;
            cur2 = cur2.next;
        }
        return ans;

    }
}