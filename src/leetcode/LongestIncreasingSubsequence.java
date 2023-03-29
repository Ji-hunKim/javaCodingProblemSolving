package leetcode;

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if(len == 1) return 1;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxVal = 0;

        for(int i=len-2; i>-1; i--){
            int maxDp = 0;
            for(int j=i+1; j<len; j++){
                if(nums[i] < nums[j]){
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp+1;
            if(maxDp+1 > maxVal) maxVal = maxDp+1;
        }
        return maxVal;
    }
}
