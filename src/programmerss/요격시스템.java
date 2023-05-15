package programmerss;

import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int before = 0;

        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] obj1, int[] obj2){
                if(obj1[1] <= obj2[1]) return -1;
                else return 1;
            }
        });

        for(int i=0; i<targets.length; i++) {
            if(targets[i][0] >= before) {
                before = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
