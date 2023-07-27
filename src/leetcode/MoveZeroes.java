package leetcode;

class Solution {
    public void moveZeroes(int[] nums) {
        int temp[] = new int[nums.length];
        int j=0;
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
                temp[j] = nums[i];
                j++;
            }else{
                cnt++;
            }
        }

        for(int i=0; i<nums.length-cnt; i++){
            nums[i] = temp[i];
        }
        for(int i=nums.length-cnt; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}