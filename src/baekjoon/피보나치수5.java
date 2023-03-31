package baekjoon;

import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt() ;


        if(num == 0 || num == 1) System.out.println(num);
        else{
            int dp[] = new int[num+1];

            dp[0] = 0;
            dp[1] = 1;

            for(int i=2; i<num+1; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }

            System.out.println(dp[num]);
        }

    }
}