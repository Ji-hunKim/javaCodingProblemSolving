package leetcode;

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int idx = 0; idx < nums1.length && idx < k; idx++) {
            queue.offer(new int[] { nums1[idx], nums2[0], 0 });
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(curr[0]);
            temp.add(curr[1]);
            result.add(temp);
            if (curr[2] == nums2.length - 1) {
                continue;
            }
            queue.add(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
        }
        return result;
    }

}