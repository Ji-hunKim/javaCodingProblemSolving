package leetcode;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = 1;
        int len = numbers.length;
        while(a<len-1){
            if(numbers[a] + numbers[b] == target) break;
            else{
                if(b == len-1){
                    while(a != len-1){
                        a++;
                        if(numbers[a-1] != numbers[a]) break;
                    }
                    b = a;
                }
                b++;
            }
        }
        return new int[]{a+1,b+1};
    }
}