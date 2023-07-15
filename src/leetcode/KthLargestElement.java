package leetcode;

import java.util.*;

public class KthLargest {

    private final PriorityQueue<Integer> q;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>();
        for (int a :nums) {
            add(a);
        }
    }

    public int add(int val) {
        q.offer(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}