package baekjoon;

import java.util.*;

class 쉽게푸는문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int begin = sc.nextInt();
        int end = sc.nextInt();

        int num = 1;
        int idx = 0;
        int answer = 0;

        Loop1:
        while(true){
            for(int i=1; i<num+1; i++){
                idx++;
                if(idx >= begin && idx <= end) {
                    answer += num;
                }
                if(idx > end) break Loop1;
            }

            num++;
        }

        System.out.println(answer);
    }
}