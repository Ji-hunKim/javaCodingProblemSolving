package leetcode;

class Solution {
    public int maxProduct(int[] nums) {
        int maxProducts = nums[0];
        int minProducts = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int now = nums[i];
            int a = maxProducts * now;
            int b = minProducts * now;
            maxProducts = Math.max(now, Math.max(a, b));
            minProducts = Math.min(now, Math.min(a, b));
            ans = Math.max(ans, maxProducts);
        }
        return ans;
    }
};