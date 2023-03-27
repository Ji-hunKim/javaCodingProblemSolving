class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int mul = 1;

        for(int i=0; i<nums.length; i++){
            mul *= nums[i];
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) answer[i] = mul / nums[i];
            else{
                answer[i] = 1;
                for(int j=0; j<nums.length; j++){
                    if(i!=j) answer[i] *= nums[j];
                }
            }
        }
        return answer;
    }
}