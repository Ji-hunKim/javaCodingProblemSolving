package programmers;

import java.util.ArrayList;

public class Solution {    	//소수찾기
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1; k<nums.length;k++){
                    alist.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        for(int m : alist){
            for(int l = 2; l<m;l++){
                if(m%l == 0){
                    break;
                }
            if(m-1 == l){
                answer++;
                }
            }
        }
        return answer;
    }
}
