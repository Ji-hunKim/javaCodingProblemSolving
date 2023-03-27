package programmers;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<arr.length; i++){
            int ele = arr[i];
            if(ele % divisor == 0) list.add(ele);
        }
        
        Collections.sort(list);
        
        int liSize = list.size();
        if(liSize == 0) {
            int answer[] = new int[1];
            answer[0] = -1;
            return answer;
        }
        int answer[] = new int[liSize];
        for (int i = 0; i<liSize; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}