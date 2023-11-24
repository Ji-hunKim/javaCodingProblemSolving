package programmerss;

import java.util.*;

class n2배열자르기 {
    public int[] solution(int n, long left, long right) {

        int k  = (int)(right - left) + 1;
        int[] answer = new int[k];

        int idx = 0;

        for(long i=left; i<=right; i++){
            if(i/n > i%n) answer[idx] = (int)(i/n + 1);
            else answer[idx] = (int)(i%n + 1);
            idx++;
        }

        return answer;

    }
}