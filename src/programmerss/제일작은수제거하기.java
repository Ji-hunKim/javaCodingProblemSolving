package programmers;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int arrLen = arr.length;
        if(arrLen == 1){
            int[] answer = {-1};
            return answer;
        }
        else{
            int minVal = arr[0];
            for(int a: arr) if(minVal>a) minVal = a;
            int[] answer = new int[arrLen-1];
            int k = 0;
            for(int i = 0; i<arrLen-1; i++) {
                if(arr[k] == minVal) k++;
                answer[i] = arr[k];
                k++;
            }
            return answer;
        }
    }
}