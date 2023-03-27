class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = nums[i];
        }

        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}