package leetcode;

class Solution {
    public int subarraySum(int[] nums, int k) {

        // 1. dp
        int len = nums.length;
        int cnt = 0;

        int[] dp = new int[len+1];
        for (int i = 0; i < len; i++) { // dp[i]는 현재 인덱스 전(i-1)까지의 누적합
            dp[i+1] = dp[i]+nums[i];
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = i+1; j < dp.length; j++) {
                if(dp[j]-dp[i] == k){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}