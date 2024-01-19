package leetcode;

class Solution {
    public int removeDuplicates(int[] nums) {
        int[] temp = new int[nums.length];
        int idx = nums[0];
        temp[0] = nums[0];
        int cnt = 1;
        int k = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == idx){
                cnt++;
                if(cnt == 2){
                    temp[k] = nums[i];
                    k++;
                }else if(cnt > 2){
                    continue;
                }
            }else{
                temp[k] = nums[i];
                k++;
                cnt = 1;
                idx = nums[i];
            }
        }

        for(int i=0; i<k; i++){
            nums[i] = temp[i];
        };

        return k;
    }
}
