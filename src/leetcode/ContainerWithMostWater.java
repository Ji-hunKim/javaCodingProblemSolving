package leetcode;

class Solution {
    public int maxArea(int[] height) {
        int a=0;
        int b=height.length-1;
        int maxVal = Integer.MIN_VALUE;


        while(b != a){
            if(height[a]>height[b]){
                maxVal = Math.max(maxVal,(b-a)*height[b]);
                b--;
            }else{
                maxVal = Math.max(maxVal,(b-a)*height[a]);
                a++;
            }
        }
        return maxVal;
    }
}